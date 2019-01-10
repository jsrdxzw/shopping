package com.natsuki.ego.manager.service.impl;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.manager.service.ManagerItemDescService;
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
public class ManagerItemDescServiceImpl implements ManagerItemDescService {

    @Autowired
    private ItemDescService itemDescServiceProxy;


    @Override
    public EgoResult getItemDesc(Long itemId) {
        TbItemDesc itemDesc = itemDescServiceProxy.getItemDesc(itemId);
        if (itemDesc != null) {
            return new EgoResult(itemDesc);
        }
        return new EgoResult(null);
    }
}
