package com.natsuki.ego.portal.controller;

import com.natsuki.ego.portal.service.PortalContentService;
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
@RequestMapping("/content")
public class PortalContentController {
    @Autowired
    private PortalContentService contentService;

    @RequestMapping(value = "/index/list",produces = MediaType.TEXT_HTML_VALUE+";charset=UTF-8")
    @ResponseBody
    public String getContentIndex(Long categoryId){
        return contentService.getContentListByCid(categoryId);
    }

}
