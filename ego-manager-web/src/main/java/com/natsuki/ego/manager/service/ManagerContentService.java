package com.natsuki.ego.manager.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.pojo.TbContent;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-11
 * @Description:
 */
public interface ManagerContentService {
    /**
     * @param cid
     * @param page
     * @param rows
     * @return
     */
    PageResult<TbContent> selectContent(Long cid, Integer page, Integer rows);

    /**
     * 门户首页
     * @param content
     * @return
     */
    EgoResult saveContent(TbContent content);
}
