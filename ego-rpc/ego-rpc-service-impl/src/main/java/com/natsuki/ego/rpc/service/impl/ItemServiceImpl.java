package com.natsuki.ego.rpc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.mapper.TbItemDescMapper;
import com.natsuki.ego.rpc.mapper.TbItemMapper;
import com.natsuki.ego.rpc.mapper.TbItemParamItemMapper;
import com.natsuki.ego.rpc.pojo.*;
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

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Autowired
    private TbItemParamItemMapper paramItemMapper;

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

    @Override
    public EgoResult updateItemStatus(List<Long> itemIds, Boolean flag) {

        TbItem item = new TbItem();
        if (flag){
            item.setStatus((byte) 1);
        } else {
            item.setStatus((byte) 2);
        }
        //动态生成sql语句
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdIn(itemIds);
        tbItemMapper.updateByExampleSelective(item,tbItemExample);
        return EgoResult.ok();
    }

    @Override
    public EgoResult deleteItem(List<Long> itemIds) {
        TbItemExample tbItemExample = new TbItemExample();
        TbItemExample.Criteria criteria = tbItemExample.createCriteria();
        criteria.andIdIn(itemIds);
        tbItemMapper.deleteByExample(tbItemExample);
        return EgoResult.ok();
    }

    @Override
    public EgoResult saveItem(TbItem item, TbItemDesc desc, TbItemParamItem paramItem) {
        tbItemMapper.insert(item);
        tbItemDescMapper.insert(desc);
        paramItemMapper.insert(paramItem);
        return EgoResult.ok();
    }

    @Override
    public EgoResult updateItem(TbItem item, TbItemDesc desc) {
        //更新商品的基本信息
        tbItemMapper.updateByPrimaryKeySelective(item);

        TbItemDescExample tbItemDescExample = new TbItemDescExample();
        TbItemDescExample.Criteria criteria = tbItemDescExample.createCriteria();
        criteria.andItemIdEqualTo(desc.getItemId());
        long rows = tbItemDescMapper.countByExample(tbItemDescExample);

        //判断商品是否存在描述信息
        if (rows==0){
            tbItemDescMapper.insert(desc);
        } else {
            desc.setCreated(null);
            tbItemDescMapper.updateByPrimaryKeySelective(desc);
        }
        return EgoResult.ok();
    }

    @Override
    public TbItem selectTbItem(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }
}
