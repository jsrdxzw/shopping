package com.natsuki.ego.manager.controller;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.TreeNode;
import com.natsuki.ego.manager.service.ManagerContentCategoryService;
import com.natsuki.ego.rpc.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ManagerContentCategoryService contentCategoryService;

    @RequestMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public List<TreeNode> contentCategoryList(@RequestParam(defaultValue = "0") Long id){
        return contentCategoryService.getContentCategory(id);
    }

    @RequestMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult contentCategoryCreate(TbContentCategory contentCategory){
        return contentCategoryService.saveContentCategory(contentCategory);
    }

    @RequestMapping(value = "/delete",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult contentCategoryDelete(Long id){
        contentCategoryService.deleteContentCategory(id);
        return EgoResult.ok();
    }
}
