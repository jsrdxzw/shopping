package com.natsuki.ego.manager.service;

import com.natsuki.ego.beans.TreeNode;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-09
 * @Description: 商品类
 */
public interface ManagerItemCatService {
    /**
     * 加载子节点集合
     * @param id 节点id
     * @return 子节点
     */
    List<TreeNode> getItemCatList(Long id);
}
