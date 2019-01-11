package com.natsuki.ego.rpc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.mapper.TbItemParamMapper;
import com.natsuki.ego.rpc.pojo.TbItemParam;
import com.natsuki.ego.rpc.pojo.TbItemParamExample;
import com.natsuki.ego.rpc.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description:
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;

    @Override
    public PageResult<TbItemParam> getTbItemParamList(Integer page, Integer rows) {
        PageResult<TbItemParam> result = new PageResult<>();

        TbItemParamExample tbItemParamExample = new TbItemParamExample();

        //分页参数指定
        Page pg = PageHelper.startPage(page, rows);

        //查询text大字段的方法
        List<TbItemParam> tbItemParams = itemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
        result.setRows(tbItemParams);
        result.setTotal(pg.getTotal());

        return result;
    }

    @Override
    public TbItemParam getTbItemParam(Long cid) {

        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = tbItemParamExample.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> tbItemParams = itemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
        if (tbItemParams != null && tbItemParams.size() > 0) {
            return tbItemParams.get(0);
        }
        return null;
    }

    @Override
    public EgoResult saveTbItemParam(TbItemParam itemParam) {
        try {
            itemParamMapper.insert(itemParam);
            return EgoResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EgoResult deleteTbItemParam(List<Long> ids) {
        try {
            TbItemParamExample example = new TbItemParamExample();
            TbItemParamExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            itemParamMapper.deleteByExample(example);
            return EgoResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
