package com.natsuki.ego.search.service.impl;

import com.natsuki.ego.rpc.pojo.TbItem;
import com.natsuki.ego.rpc.service.ItemService;
import com.natsuki.ego.search.dao.ItemDao;
import com.natsuki.ego.search.entity.Item;
import com.natsuki.ego.search.entity.SearchResult;
import com.natsuki.ego.search.service.SearchItemService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-14
 * @Description:
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ItemService itemServiceProxy;


    @Override
    public SearchResult getItem(String itemKeywords, Integer page) {

        SolrQuery params = new SolrQuery();

        //设置默认查询字段
        params.set("df", "item_keywords");

        //设置查询条件
        if (!StringUtils.isEmpty(itemKeywords)) {
            params.setQuery(itemKeywords);
        } else {
            //查询所有
            params.set("q", "*:*");
        }

        //设置分页参数
        Integer rows = 20;
        if (page < 1) {
            page = 1;
        }
        Integer maxPage = 100;
        if (page > maxPage) {
            page = maxPage;
        }
        Integer start = (page - 1) * rows;
        params.setStart(start);
        params.setRows(rows);
        //设置高亮数据
        params.setHighlight(true);
        params.addHighlightField("title");
        params.setHighlightSimplePre("<font color='yellow'>");
        params.setHighlightSimplePost("</font>");

        QueryResponse response = itemDao.getItem(params);

        //获取查询到的文档集合
        SolrDocumentList results = response.getResults();

        //获得查询的高亮数据
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();

        //获取总记录数
        Long total = results.getNumFound();

        DocumentObjectBinder documentObjectBinder = new DocumentObjectBinder();

        //转化结果数据
        List<Item> list = documentObjectBinder.getBeans(Item.class, results);

        for (Item item : list) {
            String id = item.getId();
            //获得某个商品信息的高亮数据
            Map<String, List<String>> map = highlighting.get(id);
            List<String> title = map.get("title");
            if (title != null && title.size() > 0) {
                item.setTitle(title.get(0));
            }
        }

        SearchResult result = new SearchResult();
        result.setMaxPage(Long.valueOf(maxPage));
        result.setTotal(total);
        result.setList(list);

        return result;
    }

    @Override
    public TbItem getItem(Long id) {
        return itemServiceProxy.selectTbItem(id);
    }
}
