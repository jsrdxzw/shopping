package com.natsuki.ego.manager.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.pojo.TbItemParam;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description:
 */
public interface ManagerItemParamService {

    /**
     * 实现商品规格分页显示
     * @param page 当前页数
     * @param rows 每页的查询条数
     * @return TbItemParam集合
     */
    PageResult<TbItemParam> getItemParamList(Integer page,Integer rows);

    /**
     * 根据商品类目id查询对应的规格参数模版
     * @param cid  商品类目id
     * @return 返回数据
     */
    EgoResult getItemParamByCid(Long cid);

    /**
     * 新增商品规格
     * @param cid
     * @param paramData
     * @return
     */
    EgoResult saveItemParam(Long cid,String paramData);

    EgoResult deleteItemParam(Long[] ids);

}
