package com.natsuki.ego.manager.service;

import com.natsuki.ego.beans.EgoResult;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
public interface ManagerParamItemService {

    /**
     * 加载商品规格
     * @param itemId
     * @return
     */
    EgoResult getParamItem(Long itemId);
}
