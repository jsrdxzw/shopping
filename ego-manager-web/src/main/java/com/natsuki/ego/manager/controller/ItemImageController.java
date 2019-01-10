package com.natsuki.ego.manager.controller;

import com.natsuki.ego.beans.PictureResult;
import com.natsuki.ego.manager.service.ManagerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description: 商品图片控制器
 */
@Controller
@RequestMapping("/pic")
public class ItemImageController {
    @Autowired
    private ManagerItemService managerItemService;

    @RequestMapping(value = "/upload",produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
    @ResponseBody
    public PictureResult picUpload(MultipartFile uploadFile){
        return managerItemService.uploadItemPic(uploadFile);
    }
}
