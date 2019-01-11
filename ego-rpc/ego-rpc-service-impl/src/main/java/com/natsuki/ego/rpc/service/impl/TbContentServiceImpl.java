package com.natsuki.ego.rpc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.mapper.TbContentMapper;
import com.natsuki.ego.rpc.pojo.TbContent;
import com.natsuki.ego.rpc.pojo.TbContentExample;
import com.natsuki.ego.rpc.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public PageResult<TbContent> getTbContent(Long cid, Integer page, Integer rows) {
        try {
            PageResult<TbContent> result = new PageResult<>();
            Page pg = PageHelper.startPage(page, rows);
            TbContentExample tbContentExample = new TbContentExample();
            TbContentExample.Criteria criteria = tbContentExample.createCriteria();
            criteria.andCategoryIdEqualTo(cid);
            List<TbContent> tbContents = contentMapper.selectByExampleWithBLOBs(tbContentExample);

            result.setTotal(pg.getTotal());
            result.setRows(tbContents);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EgoResult saveTbContent(TbContent content) {
        try {
            contentMapper.insert(content);
            return EgoResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
