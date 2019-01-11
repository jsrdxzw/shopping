package com.natsuki.ego.rpc.service.impl;

import com.natsuki.ego.rpc.mapper.TbItemParamItemMapper;
import com.natsuki.ego.rpc.pojo.TbItemParamItem;
import com.natsuki.ego.rpc.pojo.TbItemParamItemExample;
import com.natsuki.ego.rpc.service.ParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
@Service
public class ParamItemServiceImpl implements ParamItemService {

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Override
    public TbItemParamItem getTbItemParamItem(Long itemId) {

        TbItemParamItemExample tbItemParamItemExample = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = tbItemParamItemExample.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> tbItemParamItems = itemParamItemMapper.selectByExampleWithBLOBs(tbItemParamItemExample);
        if (tbItemParamItems!=null && tbItemParamItems.size()>0){
            return tbItemParamItems.get(0);
        }
        return null;
    }
}
