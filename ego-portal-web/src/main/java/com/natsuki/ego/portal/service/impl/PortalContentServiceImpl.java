package com.natsuki.ego.portal.service.impl;

import com.natsuki.ego.beans.BigPicture;
import com.natsuki.ego.beans.JsonUtils;
import com.natsuki.ego.portal.service.PortalContentService;
import com.natsuki.ego.rpc.pojo.TbContent;
import com.natsuki.ego.rpc.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.SetParams;

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

    @Value("${CONTENT_PICTURE}")
    private String contentPicKey;
    @Value("${EXPIRE_TIME_IN_SECOND}")
    private Integer expireTime;

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public String getContentListByCid(Long cid) {
        String jsonStr = jedisCluster.get(contentPicKey);
        if (!StringUtils.isEmpty(jsonStr)){
            return jsonStr;
        }
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
        jsonStr = JsonUtils.objectToJson(bigPictures);
        jedisCluster.expire(contentPicKey,expireTime);
        jedisCluster.set(contentPicKey,jsonStr);
        return jsonStr;
    }
}
