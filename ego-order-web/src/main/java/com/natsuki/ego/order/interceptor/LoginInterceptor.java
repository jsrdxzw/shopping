package com.natsuki.ego.order.interceptor;

import com.natsuki.ego.beans.CookieUtils;
import com.natsuki.ego.beans.JsonUtils;
import com.natsuki.ego.rpc.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-17
 * 拦截器两种实现
 * 1 继承HandlerInterceptorAdapter
 * 2 实现接口HandlerInterceptor
 * @Description: 登录拦截器，验证用户是否已经登录
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //验证用户是否登录 cookie
        String token = CookieUtils.getCookieValue(request, "sso_token");
        if (!StringUtils.isEmpty(token)) {
            String jsonStr = jedisCluster.get(token);
            if (!StringUtils.isEmpty(jsonStr)) {
                TbUser user = JsonUtils.jsonToPojo(jsonStr, TbUser.class);
                request.setAttribute("user", user);
                //放行
                return true;
            }
        }
        String url = request.getRequestURL().toString();
        response.sendRedirect("http://localhost:8083/login?redirect=" + url);
        return false;
    }
}
