package com.natsuki.ego.search.controller;

import com.natsuki.ego.search.entity.SearchResult;
import com.natsuki.ego.search.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-14
 * @Description:
 */
@Controller
public class SearchItemController {

    @Autowired
    private SearchItemService searchItemService;

    @RequestMapping("/{url}")
    public String loadPage(@PathVariable String url, String q, @RequestParam(defaultValue = "1") Integer page, Model model){
        SearchResult result = searchItemService.getItem(q, page);
        model.addAttribute("query",q);
        model.addAttribute("itemList",result.getList());
        model.addAttribute("page",page);
        model.addAttribute("maxpage",result.getMaxPage());
        return url;
    }
}
