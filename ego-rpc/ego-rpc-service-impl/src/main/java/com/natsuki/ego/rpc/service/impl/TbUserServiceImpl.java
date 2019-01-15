package com.natsuki.ego.rpc.service.impl;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.rpc.mapper.TbUserMapper;
import com.natsuki.ego.rpc.pojo.TbUser;
import com.natsuki.ego.rpc.pojo.TbUserExample;
import com.natsuki.ego.rpc.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-15
 * @Description:
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public EgoResult getTbUserByCond(String cond, Integer type) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();

        //封装查询条件
        switch (type) {
            case 1:
                criteria.andUsernameEqualTo(cond);
                break;
            case 2:
                criteria.andPhoneEqualTo(cond);
                break;
            default:
                criteria.andEmailEqualTo(cond);
                break;
        }

        List<TbUser> tbUsers = userMapper.selectByExample(example);
        EgoResult egoResult = new EgoResult();
        egoResult.setStatus(200);
        egoResult.setMsg("ok");
        if (tbUsers != null && tbUsers.size() > 0) {
            egoResult.setData(false);
        } else {
            //用户名可用
            egoResult.setData(true);
        }
        return egoResult;
    }

    @Override
    public EgoResult saveUser(TbUser user) {
        EgoResult result = new EgoResult();
        try {
            Date date = new Date();
            user.setCreated(date);
            user.setUpdated(date);
            userMapper.insert(user);
            result.setMsg("注册成功");
            result.setStatus(200);
        } catch (Exception e){
            result.setStatus(400);
            result.setMsg("注册失败");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public TbUser selectUserByUsername(String username) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUser> tbUsers = userMapper.selectByExample(example);
        if (tbUsers!=null && tbUsers.size()==1){
            return tbUsers.get(0);
        }
        return null;
    }
}
