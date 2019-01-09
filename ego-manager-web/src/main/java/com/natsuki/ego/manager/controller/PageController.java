package com.natsuki.ego.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-08
 * @Description: 页面跳转
 */
@Controller
public class PageController {


    /**
     * 商场后台系统
     * @return 页面
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    /**
     * @param page 接受的页面跳转参数
     * @return 请求的页面
     */
    @RequestMapping("{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

}
