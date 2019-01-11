package com.natsuki.ego.rpc.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.rpc.pojo.TbItemParam;

import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description: 商品规格参数
 */
public interface ItemParamService {

    /**
     * 分页获取商品规格参数
     * @param page 当前页面
     * @param rows 每页条数
     * @return 封装结果
     */
    PageResult<TbItemParam> getTbItemParamList(Integer page,Integer rows);

    /**
     * @param cid 类目id
     * @return 规格参数模版对象
     */
    TbItemParam getTbItemParam(Long cid);

    /**
     * 添加商品规格信息
     * @param itemParam
     * @return
     */
    EgoResult saveTbItemParam(TbItemParam itemParam);

    /**
     * 批量删除商品规格信息
     * @param ids id集合
     * @return 操作结果
     */
    EgoResult deleteTbItemParam(List<Long> ids);
}
