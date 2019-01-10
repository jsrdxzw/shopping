package com.natsuki.ego.rpc.service.impl;

import com.natsuki.ego.rpc.mapper.TbItemDescMapper;
import com.natsuki.ego.rpc.pojo.TbItemDesc;
import com.natsuki.ego.rpc.service.ItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description:
 */
@Service
public class ItemDescServiceImpl implements ItemDescService {

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public TbItemDesc getItemDesc(Long itemId) {
        return tbItemDescMapper.selectByPrimaryKey(itemId);
    }
}
