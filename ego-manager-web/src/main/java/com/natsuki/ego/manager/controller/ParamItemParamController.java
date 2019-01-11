package com.natsuki.ego.manager.controller;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.manager.service.ManagerParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
@Controller
public class ParamItemParamController {

    @Autowired
    private ManagerParamItemService paramItemService;

    @RequestMapping(value = "/param/item/query/{itemId}",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult itemParamQuery(@PathVariable Long itemId){
        return paramItemService.getParamItem(itemId);
    }
}
