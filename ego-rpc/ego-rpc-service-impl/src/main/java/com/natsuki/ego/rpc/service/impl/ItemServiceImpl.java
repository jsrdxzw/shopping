package com.natsuki.ego.rpc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.mapper.TbItemMapper;
import com.natsuki.ego.rpc.pojo.TbItem;
import com.natsuki.ego.rpc.pojo.TbItemExample;
import com.natsuki.ego.rpc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-08
 * @Description:
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public PageResult<TbItem> selectItemList(Integer page, Integer rows) {
        //执行分页操作
        Page ps = PageHelper.startPage(page, rows);

        //查询的商品实例
        TbItemExample tbItemExample = new TbItemExample();

        //执行数据库查询操作
        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);

        //设置PageResult
        PageResult<TbItem> tbItemPageResult = new PageResult<>();
        tbItemPageResult.setRows(tbItems);
        tbItemPageResult.setTotal(ps.getTotal());

        return tbItemPageResult;
    }
}
