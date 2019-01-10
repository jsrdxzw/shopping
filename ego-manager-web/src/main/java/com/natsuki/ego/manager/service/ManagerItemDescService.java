package com.natsuki.ego.manager.service;

import com.natsuki.ego.beans.EgoResult;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description:
 */
public interface ManagerItemDescService {
    /**
     * 获得需要回显的商品描述信息
     * @param itemId 商品id
     * @return 返回的包装类
     */
    EgoResult getItemDesc(Long itemId);
}
