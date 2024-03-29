package com.natsuki.ego.search.dao.impl;

import com.natsuki.ego.search.dao.ItemDao;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-14
 * @Description:
 */
@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private HttpSolrServer solrServer;

    @Override
    public QueryResponse getItem(SolrQuery params) {
        try {
            return solrServer.query(params);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
