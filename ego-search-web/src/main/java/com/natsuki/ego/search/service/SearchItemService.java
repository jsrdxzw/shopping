package com.natsuki.ego.search.service;

        import com.natsuki.ego.rpc.pojo.TbItem;
        import com.natsuki.ego.search.entity.SearchResult;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-14
 * @Description:
 */
public interface SearchItemService {

    /**
     * 商品信息关键字，分页查询
     * @param itemKeywords
     * @param page
     * @return
     */
    SearchResult getItem(String itemKeywords, Integer page);

    /**
     * 查询商品的基本信息
     * @param id 商品id
     * @return
     */
    TbItem getItem(Long id);
}
