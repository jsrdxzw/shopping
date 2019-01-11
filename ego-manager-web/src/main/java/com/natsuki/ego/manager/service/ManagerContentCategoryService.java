package com.natsuki.ego.manager.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.TreeNode;
import com.natsuki.ego.rpc.pojo.TbContentCategory;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
public interface ManagerContentCategoryService {

    /**
     * @param pid 父id
     * @return 节点包装类
     */
    List<TreeNode> getContentCategory(Long pid);

    /**
     * 添加内容分类节点
     * @param contentCategory
     * @return
     */
    EgoResult saveContentCategory(TbContentCategory contentCategory);

    /**
     * 删除内容分类节点
     * @param id 节点id
     */
    void deleteContentCategory(Long id);
}
