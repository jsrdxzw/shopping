package com.natsuki.ego.portal.controller;

import com.natsuki.ego.portal.service.PortalItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-12
 * @Description:
 */
@Controller
@RequestMapping("/item")
public class PortalItemCatController {
    @Autowired
    private PortalItemCatService portalItemCatService;

    @RequestMapping(value = "/cat",produces = MediaType.TEXT_HTML_VALUE+";charset=UTF-8")
    @ResponseBody
    public String itemCat(){
        return portalItemCatService.loadItemCatService();
    }

}
