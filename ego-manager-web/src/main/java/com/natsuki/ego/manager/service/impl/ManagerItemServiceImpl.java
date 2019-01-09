package com.natsuki.ego.manager.service.impl;

import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.manager.service.ManagerItemService;
import com.natsuki.ego.rpc.pojo.TbItem;
import com.natsuki.ego.rpc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-08
 * @Description:
 */
@Service
public class ManagerItemServiceImpl implements ManagerItemService {

    @Autowired
    private ItemService itemServiceProxy;

    @Override
    public PageResult<TbItem> selectItemListService(Integer page, Integer rows) {
        return itemServiceProxy.selectItemList(page,rows);
    }
}
