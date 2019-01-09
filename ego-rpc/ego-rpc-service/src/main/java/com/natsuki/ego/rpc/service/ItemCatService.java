package com.natsuki.ego.rpc.service;

import com.natsuki.ego.rpc.pojo.TbItemCat;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-09
 * @Description: 商品类别
 */
public interface ItemCatService {

    /**
     * 根据某个节点的id查询子节点
     * @param id id
     * @return 所有子节点
     */
    List<TbItemCat> getItemCatListByParentId(Long id);
}
