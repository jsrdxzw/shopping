package com.natsuki.ego.rpc.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.pojo.TbItem;
import com.natsuki.ego.rpc.pojo.TbItemDesc;
import com.natsuki.ego.rpc.pojo.TbItemParamItem;

import java.util.List;

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

    /**
     * 完成商品的上下架的状态修改
     * @param itemIds 商品的id集合
     * @param flag true 上架 false下架
     * @return 返回结果
     */
    EgoResult updateItemStatus(List<Long> itemIds, Boolean flag);

    /**
     * 删除商品
     * @param itemIds 商品的id
     * @return 返回结果
     */
    EgoResult deleteItem(List<Long> itemIds);

    /**
     * 新增商品
     * @param item 商品类目等基本信息
     * @param desc 商品详细描述
     * @param paramItem 商品规格参数的信息
     * @return 返回结果
     */
    EgoResult saveItem(TbItem item, TbItemDesc desc, TbItemParamItem paramItem);

    /**
     * 更新商品
     * @param item 商品类目等基本信息
     * @param desc 商品详细描述
     * @return 返回结果
     */
    EgoResult updateItem(TbItem item,TbItemDesc desc);

    /**
     * 查询商品的信息
     * @param id 商品的id
     * @return 商品
     */
    TbItem selectTbItem(Long id);
}
