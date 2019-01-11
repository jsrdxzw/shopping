package com.natsuki.ego.manager.service.impl;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.manager.service.ManagerContentService;
import com.natsuki.ego.rpc.pojo.TbContent;
import com.natsuki.ego.rpc.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
@Service
public class ManagerContentServiceImpl implements ManagerContentService {

    @Autowired
    private TbContentService tbContentServiceProxy;

    @Override
    public PageResult<TbContent> selectContent(Long cid, Integer page, Integer rows) {
        return tbContentServiceProxy.getTbContent(cid,page,rows);
    }

    @Override
    public EgoResult saveContent(TbContent content) {
        Date date = new Date();
        content.setCreated(date);
        content.setUpdated(date);
        return tbContentServiceProxy.saveTbContent(content);
    }
}
