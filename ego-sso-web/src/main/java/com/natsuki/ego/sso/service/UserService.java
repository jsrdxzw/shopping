package com.natsuki.ego.sso.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.rpc.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-15
 * @Description:
 */
public interface UserService {
    /**
     * 查看唯一性
     * @param cond
     * @param type
     * @return
     */
    EgoResult getUserByCond(String cond,Integer type);

    /**
     * 注册用户
     * @param user
     * @return
     */
    EgoResult saveUser(TbUser user);

    /**
     * 查询用户
     * @param username
     * @param password
     * @return
     */
    EgoResult selectUser(String username, String password, HttpServletRequest request, HttpServletResponse response);

    /**
     * 获得用户登录状态
     * @param token 用户认证令牌
     * @return 返回结果
     */
    EgoResult getUserByToken(String token);

    /**
     * 用户登出
     * @param token
     * @return
     */
    EgoResult deleteUserByToken(String token);
}
