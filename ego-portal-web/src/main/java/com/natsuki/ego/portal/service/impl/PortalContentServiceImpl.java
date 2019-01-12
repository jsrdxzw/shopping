package com.natsuki.ego.portal.service.impl;

import com.natsuki.ego.beans.BigPicture;
import com.natsuki.ego.beans.JsonUtils;
import com.natsuki.ego.portal.service.PortalContentService;
import com.natsuki.ego.rpc.pojo.TbContent;
import com.natsuki.ego.rpc.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-12
 * @Description:
 */
@Service
public class PortalContentServiceImpl implements PortalContentService {

    @Autowired
    private TbContentService contentServiceProxy;

    @Override
    public String getContentListByCid(Long cid) {
        List<TbContent> tbContents = contentServiceProxy.selectTbContentByCid(cid);
        List<BigPicture> bigPictures = new ArrayList<>();
        for (TbContent tbContent : tbContents) {
            BigPicture bigPicture = new BigPicture();
            bigPicture.setSrcb(tbContent.getPic());
            bigPicture.setAlt(tbContent.getContent());
            bigPicture.setSrc(tbContent.getPic2());
            bigPicture.setHref(tbContent.getUrl());
            bigPictures.add(bigPicture);
        }
        return JsonUtils.objectToJson(bigPictures);
    }
}
