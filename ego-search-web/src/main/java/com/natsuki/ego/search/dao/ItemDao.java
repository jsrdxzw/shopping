package com.natsuki.ego.search.dao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-14
 * @Description:
 */
public interface ItemDao {
    /**
     * @param params 查询参数
     * @return 商品索引返回结果
     */
    QueryResponse getItem(SolrQuery params);
}
