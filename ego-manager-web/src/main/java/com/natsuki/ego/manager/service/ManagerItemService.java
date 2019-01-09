package com.natsuki.ego.manager.service;

import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.pojo.TbItem;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-08
 * @Description: 商品信息的消费者业务接口
 */
public interface ManagerItemService {

    /**
     * @param page 当前页
     * @param rows 每页的条数
     * @return  包装对象
     */
    PageResult<TbItem> selectItemListService(Integer page, Integer rows);
}
