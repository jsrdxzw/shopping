package com.natsuki.ego.rpc.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.pojo.TbContent;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
public interface TbContentService {
    /**
     * 根据分类的id查询该分类下的所有内容
     * @param cid 分类的id
     * @param page 当前页
     * @param rows 每页条数
     * @return 结果页
     */
    PageResult<TbContent> getTbContent(Long cid,Integer page,Integer rows);

    /**
     * 完成内容的添加
     * @param content
     * @return
     */
    EgoResult saveTbContent(TbContent content);
}
