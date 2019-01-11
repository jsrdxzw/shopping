package com.natsuki.ego.rpc.service;

import com.natsuki.ego.rpc.pojo.TbItemParamItem;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
public interface ParamItemService {
    /**
     * 根据商品的id查询商品对应的规格参数
     * @param itemId 商品id
     * @return 规格参数
     */
    TbItemParamItem getTbItemParamItem(Long itemId);
}
