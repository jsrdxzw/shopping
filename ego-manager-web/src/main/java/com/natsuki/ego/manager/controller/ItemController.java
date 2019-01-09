package com.natsuki.ego.manager.controller;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.manager.service.ManagerItemService;
import com.natsuki.ego.rpc.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-08
 * @Description: 商品控制器
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ManagerItemService managerItemService;

    @RequestMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public PageResult<TbItem> itemList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows){
        return managerItemService.selectItemListService(page,rows);
    }

    @RequestMapping(value = "/reshelf",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult reshelfItem(Long[] ids){
        return managerItemService.reshelfItem(ids);
    }

    @RequestMapping(value = "/instock",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult instockItem(Long[] ids){
        return managerItemService.instockItem(ids);
    }

    @RequestMapping(value = "/delete",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult deleteItem(Long[] ids){
        return managerItemService.deleteItem(ids);
    }

}
