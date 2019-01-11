package com.natsuki.ego.manager.service.impl;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.manager.service.ManagerParamItemService;
import com.natsuki.ego.rpc.pojo.TbItemParamItem;
import com.natsuki.ego.rpc.service.ParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
@Service
public class ManagerParamItemServiceImpl implements ManagerParamItemService {

    @Autowired
    private ParamItemService paramItemServiceProxy;

    @Override
    public EgoResult getParamItem(Long itemId) {
        EgoResult result = null;
        try {
            TbItemParamItem tbItemParamItem = paramItemServiceProxy.getTbItemParamItem(itemId);
            result = new EgoResult();
            result.setStatus(200);
            result.setData(tbItemParamItem);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
