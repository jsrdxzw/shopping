package com.natsuki.ego.manager.controller;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.manager.service.ManagerContentService;
import com.natsuki.ego.rpc.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ManagerContentService contentService;

    @RequestMapping(value = "/query/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public PageResult<TbContent> contentCategoryDelete(Long categoryId, Integer page, Integer rows){
        return contentService.selectContent(categoryId,page,rows);
    }

    @RequestMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult contentCategorySave(TbContent content){
        return contentService.saveContent(content);
    }
}
