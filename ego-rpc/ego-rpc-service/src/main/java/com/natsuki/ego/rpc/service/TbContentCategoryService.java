package com.natsuki.ego.rpc.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.rpc.pojo.TbContentCategory;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
public interface TbContentCategoryService {

    /**
     * 加载内容分类树
     * @param pid 父类id
     * @return
     */
    List<TbContentCategory> getTbContentCategoryByPid(Long pid);

    /**
     * 新增分类
     * @param contentCategory 分类对象
     * @return
     */
    EgoResult saveContentCategory(TbContentCategory contentCategory);

    /**
     * 删除内容分类节点
     * @param id 节点id
     */
    void deleteContentCategory(Long id);
}
