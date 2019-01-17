package com.natsuki.ego.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-15
 * @Description:
 */
@Controller
public class PageController {

    @RequestMapping("{url}")
    public String loadPage(@PathVariable String url, @RequestParam(required = false) String redirect, Model model) {
        model.addAttribute("redirect", redirect);
        return url;
    }
}
