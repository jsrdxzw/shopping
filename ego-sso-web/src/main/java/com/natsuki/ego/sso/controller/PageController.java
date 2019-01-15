package com.natsuki.ego.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-15
 * @Description:
 */
@Controller
public class PageController {

    @RequestMapping("{url}")
    public String loadPage(@PathVariable String url){
        return url;
    }
}
