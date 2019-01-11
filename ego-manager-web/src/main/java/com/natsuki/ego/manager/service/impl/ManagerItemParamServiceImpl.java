package com.natsuki.ego.manager.service.impl;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.manager.service.ManagerItemParamService;
import com.natsuki.ego.rpc.pojo.TbItemParam;
import com.natsuki.ego.rpc.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description:
 */
@Service
public class ManagerItemParamServiceImpl implements ManagerItemParamService {

    @Autowired
    private ItemParamService itemParamServiceProxy;

    @Override
    public PageResult<TbItemParam> getItemParamList(Integer page, Integer rows) {
        return itemParamServiceProxy.getTbItemParamList(page,rows);
    }

    @Override
    public EgoResult getItemParamByCid(Long cid) {
        TbItemParam tbItemParam = itemParamServiceProxy.getTbItemParam(cid);
        EgoResult result = new EgoResult();
        result.setStatus(200);
        result.setData(tbItemParam);
        result.setMsg("ok");
        return result;
    }

    @Override
    public EgoResult saveItemParam(Long cid, String paramData) {
        TbItemParam param = new TbItemParam();
        param.setItemCatId(cid);
        param.setParamData(paramData);
        Date date = new Date();
        param.setCreated(date);
        param.setUpdated(date);
        return itemParamServiceProxy.saveTbItemParam(param);
    }

    @Override
    public EgoResult deleteItemParam(Long[] ids) {
        return itemParamServiceProxy.deleteTbItemParam(Arrays.asList(ids));
    }
}
