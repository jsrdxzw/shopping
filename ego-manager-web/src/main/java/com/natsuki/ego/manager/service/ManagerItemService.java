package com.natsuki.ego.manager.service;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.beans.PageResult;
import com.natsuki.ego.beans.PictureResult;
import com.natsuki.ego.rpc.pojo.TbItem;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-08
 * @Description: 商品信息的消费者业务接口
 */
public interface ManagerItemService {

    /**
     * 分页查询商品信息
     * @param page 当前页
     * @param rows 每页的条数
     * @return  包装对象
     */
    PageResult<TbItem> selectItemListService(Integer page, Integer rows);

    /**
     * 商品信息的上架
     * @param ids 商品id
     * @return 返回包装对象
     */
    EgoResult reshelfItem(Long[] ids);

    /**
     * 商品信息的下架
     * @param ids
     * @return 返回包装对象
     */
    EgoResult instockItem(Long[] ids);

    /**
     * 删除商品
     * @param ids
     * @return 返回包装对象
     */
    EgoResult deleteItem(Long[] ids);

    /**
     * 完成图片的上传
     * @param file 客户端传来的file信息类
     * @return 图片上传后的返回对象
     */
    PictureResult uploadItemPic(MultipartFile file);

    /**
     * 完成商品信息的添加
     * @param item 商品对象
     * @param desc 商品描述
     * @param paramData 商品规格字符串
     * @return 返回包装对象
     */
    EgoResult saveItem(TbItem item,String desc,String paramData);

    /**
     * 完成商品信息的更新
     * @param item 商品对象
     * @param desc 商品描述
     * @return 返回包装对象
     */
    EgoResult updateItem(TbItem item,String desc);

}
