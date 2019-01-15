package com.natsuki.ego.rpc.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.rpc.pojo.TbUser;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-15
 * @Description: 用户登录注册接口
 */
public interface TbUserService {

    /**
     * 实现用户唯一性验证
     * @param cond 验证数据
     * @param type 验证类型
     * @return
     */
    EgoResult getTbUserByCond(String cond,Integer type);

    /**
     * 实现用户信息注册
     * @param user 用户
     * @return
     */
    EgoResult saveUser(TbUser user);

    /**
     * 用户验证
     * @param username 用户名
     * @return
     */
    TbUser selectUserByUsername(String username);

}
