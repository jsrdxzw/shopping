package com.natsuki.ego.manager.service.impl;

import com.natsuki.ego.beans.*;
import com.natsuki.ego.manager.service.ManagerItemService;
import com.natsuki.ego.rpc.pojo.TbItem;
import com.natsuki.ego.rpc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-08
 * @Description:
 */
@Service
public class ManagerItemServiceImpl implements ManagerItemService {

    @Autowired
    private ItemService itemServiceProxy;

    /**
     * 通过spring注入配置信息
     */
    @Value("${FTP_HOST}")
    private String FTP_HOST;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_PATH}")
    private String FTP_PATH;
    @Value("${IMAGE_HTTP_PATH}")
    private String IMAGE_HTTP_PATH;

    @Override
    public PageResult<TbItem> selectItemListService(Integer page, Integer rows) {
        return itemServiceProxy.selectItemList(page,rows);
    }

    @Override
    public EgoResult reshelfItem(Long[] ids) {
        return itemServiceProxy.updateItemStatus(Arrays.asList(ids),true);
    }

    @Override
    public EgoResult instockItem(Long[] ids) {
        return itemServiceProxy.updateItemStatus(Arrays.asList(ids),false);
    }

    @Override
    public EgoResult deleteItem(Long[] ids) {
        return itemServiceProxy.deleteItem(Arrays.asList(ids));
    }

    @Override
    public PictureResult uploadItemPic(MultipartFile file) {
        boolean flag = false;
        //上传之后的文件名
        String filename = IDUtils.genImageName();
        //获得上传文件的原始名字
        String oriName = file.getOriginalFilename();
        //扩展名 eg .jpg
        String ext = oriName.substring(oriName.lastIndexOf("."));
        filename = filename + ext;
        //实现文件上传
        try {
            flag = FTPUtil.uploadFile(FTP_HOST,FTP_PORT,FTP_USERNAME,FTP_PASSWORD,FTP_PATH,filename,file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        PictureResult pictureResult = new PictureResult();
        if (flag){
            pictureResult.setError(0);
            pictureResult.setUrl(IMAGE_HTTP_PATH+"/"+filename);
            pictureResult.setMessage("ok");
        } else {
            pictureResult.setError(1);
            pictureResult.setUrl("url");
            pictureResult.setMessage("error");
        }
        return pictureResult;
    }
}
