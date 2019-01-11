package com.natsuki.ego.manager.service.impl;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.IDUtils;
import com.natsuki.ego.beans.TreeNode;
import com.natsuki.ego.manager.service.ManagerContentCategoryService;
import com.natsuki.ego.rpc.pojo.TbContentCategory;
import com.natsuki.ego.rpc.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
@Service
public class ManagerContentCategoryServiceImpl implements ManagerContentCategoryService {

    @Autowired
    private TbContentCategoryService tbContentCategoryServiceProxy;

    @Override
    public List<TreeNode> getContentCategory(Long pid) {
        List<TreeNode> list = new ArrayList<>();
        List<TbContentCategory> tbList = tbContentCategoryServiceProxy.getTbContentCategoryByPid(pid);
        for (TbContentCategory tbContentCategory : tbList) {
            TreeNode node = new TreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            list.add(node);
        }
        return list;
    }

    @Override
    public EgoResult saveContentCategory(TbContentCategory contentCategory) {

        //先封装
        Long id = IDUtils.genItemId();
        contentCategory.setId(id);
        Date date = new Date();
        contentCategory.setCreated(date);
        contentCategory.setUpdated(date);
        contentCategory.setStatus(1);
        contentCategory.setSortOrder(1);
        contentCategory.setIsParent(false);


        return tbContentCategoryServiceProxy.saveContentCategory(contentCategory);
    }

    @Override
    public void deleteContentCategory(Long id) {
        tbContentCategoryServiceProxy.deleteContentCategory(id);
    }
}
