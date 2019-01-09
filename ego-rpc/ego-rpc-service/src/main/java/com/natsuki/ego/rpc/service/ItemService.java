package com.natsuki.ego.rpc.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.pojo.TbItem;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-08
 * @Description: 商品的接口
 */
public interface ItemService {

    /**
     * 实现商品信息的分页查询
     * @param page 当前的页码
     * @param rows 每页的显示条数
     * @return 页面数据的beans集合
     */
    PageResult<TbItem> selectItemList(Integer page, Integer rows);

    public EgoResult updateItemStatus();
}
