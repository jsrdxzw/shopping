package com.natsuki.ego.manager.controller;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.manager.service.ManagerItemParamService;
import com.natsuki.ego.rpc.pojo.TbItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description:
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ManagerItemParamService itemParamService;

    @RequestMapping(value = "/list",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public PageResult<TbItemParam> itemParamList(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "30") Integer rows){
        return itemParamService.getItemParamList(page,rows);
    }

    @RequestMapping(value = "/query/{cid}",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult itemParam(@PathVariable Long cid){
        return itemParamService.getItemParamByCid(cid);
    }

    @RequestMapping(value = "/save/{cid}",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult saveItemParam(@PathVariable Long cid,String paramData){
        return itemParamService.saveItemParam(cid,paramData);
    }

    @RequestMapping(value = "/delete",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult deleteItemParam(Long[] ids){
        return itemParamService.deleteItemParam(ids);
    }

    @RequestMapping(value = "/select/{cid}",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public EgoResult itemParamSelect(@PathVariable Long cid){
        return itemParamService.getItemParamByCid(cid);
    }
}
