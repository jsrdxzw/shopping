package com.natsuki.ego.sso.service.impl;

import com.natsuki.ego.beans.CookieUtils;
import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.JsonUtils;
import com.natsuki.ego.rpc.pojo.TbUser;
import com.natsuki.ego.rpc.service.TbUserService;
import com.natsuki.ego.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-15
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserService tbUserServiceProxy;

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public EgoResult getUserByCond(String cond, Integer type) {
        return tbUserServiceProxy.getTbUserByCond(cond, type);
    }

    @Override
    public EgoResult saveUser(TbUser user) {
        String pwd = user.getPassword();
        //密码加密
        String md5 = DigestUtils.md5DigestAsHex(pwd.getBytes());
        user.setPassword(md5);
        return tbUserServiceProxy.saveUser(user);
    }

    @Override
    public EgoResult selectUser(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        TbUser user = tbUserServiceProxy.selectUserByUsername(username);
        EgoResult result = new EgoResult();
        if (user != null) {
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (password.equals(user.getPassword())) {
                //保存到redis数据库
                String token = UUID.randomUUID().toString().replaceAll("-", "");
                jedisCluster.set(token, JsonUtils.objectToJson(user));
                //设置30分钟的有效时间
                jedisCluster.expire(token, 1800);
                //将cookie值响应到客户端
                CookieUtils.setCookie(request, response, "sso_token", token);
                result.setStatus(200);
                result.setMsg("ok");
                result.setData(token);
                return result;
            }
        }
        result.setStatus(400);
        result.setData(null);
        result.setMsg("error");
        return result;
    }

    @Override
    public EgoResult getUserByToken(String token) {
        String userInfo = jedisCluster.get(token);
        EgoResult result = new EgoResult();
        if (!StringUtils.isEmpty(userInfo)) {
            result.setStatus(200);
            result.setMsg("ok");
            result.setData(JsonUtils.jsonToPojo(userInfo,TbUser.class));
            return result;
        }
        result.setStatus(400);
        result.setData(null);
        result.setMsg("error");
        return result;
    }

    @Override
    public EgoResult deleteUserByToken(String token) {
        Long del = jedisCluster.del(token);
        EgoResult result = new EgoResult();
        if (del != 0) {
            result.setStatus(200);
            result.setMsg("ok");
            result.setData("");
            return result;
        } else {
            result.setMsg("error");
            result.setStatus(400);
            result.setData(null);
            return result;
        }
    }

}
