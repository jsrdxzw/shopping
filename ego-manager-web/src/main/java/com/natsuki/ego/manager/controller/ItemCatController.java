package com.natsuki.ego.manager.controller;

import com.natsuki.ego.beans.TreeNode;
import com.natsuki.ego.manager.service.ManagerItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-09
 * @Description:
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ManagerItemCatService managerItemCatService;

    @RequestMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public List<TreeNode> itemCatList(@RequestParam(defaultValue = "0",required = false) Long id){
        return managerItemCatService.getItemCatList(id);
    }
}
