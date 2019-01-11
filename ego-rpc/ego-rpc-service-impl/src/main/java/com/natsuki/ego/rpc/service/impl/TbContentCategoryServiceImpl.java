package com.natsuki.ego.rpc.service.impl;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.rpc.mapper.TbContentCategoryMapper;
import com.natsuki.ego.rpc.pojo.TbContentCategory;
import com.natsuki.ego.rpc.pojo.TbContentCategoryExample;
import com.natsuki.ego.rpc.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;

    @Override
    public List<TbContentCategory> getTbContentCategoryByPid(Long pid) {
        TbContentCategoryExample tbContentCategoryExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = tbContentCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(pid);
        return contentCategoryMapper.selectByExample(tbContentCategoryExample);
    }

    @Override
    public EgoResult saveContentCategory(TbContentCategory contentCategory) {

        EgoResult egoResult = null;
        try {
            //更新父节点
            TbContentCategory parent = new TbContentCategory();
            parent.setIsParent(true);
            parent.setId(contentCategory.getParentId());
            contentCategoryMapper.updateByPrimaryKeySelective(parent);

            //添加新的节点
            contentCategoryMapper.insert(contentCategory);
            egoResult = new EgoResult();
            egoResult.setStatus(200);
            egoResult.setData(contentCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return egoResult;
    }

    @Override
    public void deleteContentCategory(Long id) {

        //更新当前点击节点的父节点的isParent字段
        //判断是否有子节点
        TbContentCategory tbContentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        Long parentId = tbContentCategory.getParentId();

        TbContentCategoryExample example = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        long count = contentCategoryMapper.countByExample(example);
        //更新当前的父节点
        if (count==1){
            TbContentCategory parent = new TbContentCategory();
            parent.setId(parentId);
            parent.setIsParent(false);
            contentCategoryMapper.updateByPrimaryKeySelective(parent);
        }

        //删除当前选中的节点
        contentCategoryMapper.deleteByPrimaryKey(id);


    }
}
