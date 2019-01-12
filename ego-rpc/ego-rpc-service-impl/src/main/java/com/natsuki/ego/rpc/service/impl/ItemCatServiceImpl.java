package com.natsuki.ego.rpc.service.impl;

import com.natsuki.ego.rpc.mapper.TbItemCatMapper;
import com.natsuki.ego.rpc.pojo.TbItemCat;
import com.natsuki.ego.rpc.pojo.TbItemCatExample;
import com.natsuki.ego.rpc.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-09
 * @Description:
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> getItemCatListByParentId(Long id) {

        //数据库查询
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        return tbItemCatMapper.selectByExample(tbItemCatExample);
    }

    @Override
    public List<TbItemCat> getItemCatList() {
        return tbItemCatMapper.selectByExample(new TbItemCatExample());
    }
}
