package com.natsuki.ego.portal.service.impl;

import com.natsuki.ego.beans.CatNode;
import com.natsuki.ego.beans.CatResult;
import com.natsuki.ego.beans.JsonUtils;
import com.natsuki.ego.portal.service.PortalItemCatService;
import com.natsuki.ego.rpc.pojo.TbItemCat;
import com.natsuki.ego.rpc.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-12
 * @Description:
 */
@Service
public class PortalItemCatServiceImpl implements PortalItemCatService {
    @Autowired
    private ItemCatService itemCatServiceProxy;

    @Override
    public String loadItemCatService() {


        List<TbItemCat> itemCatList = itemCatServiceProxy.getItemCatList();

        CatResult catResult = new CatResult();
        catResult.setData(getChildren(0L,itemCatList));
        //转化为符合前端规范的格式，由于前台需要的是字符串，所以这里需要手动的转化为字符串
        return JsonUtils.objectToJson(catResult);
    }

    private List<?> getChildren(Long parentId, List<TbItemCat> itemCats) {
        List resultList = new ArrayList();
        for (TbItemCat cat : itemCats) {
            if (cat.getParentId().equals(parentId)) {
                if (cat.getIsParent()) {
                    CatNode catNode = new CatNode();
                    if (cat.getParentId() == 0) {
                        // 如果是一级分类 "<a href='/products/1.html'>图书、音像、电子书刊</a>",
                        catNode.setName(
                                "<a href='/products/" + cat.getId() + ".html'>" + cat.getName() + "</a>");
                    } else {
                        // 如果是二级分类 "电子书刊",
                        catNode.setName(cat.getName());
                    }
                    catNode.setUrl("/products/" + cat.getId() + ".html");
                    //这里面会递归调用，形成比较复杂的List嵌套结构
                    catNode.setList(getChildren(cat.getId(), itemCats));
                    resultList.add(catNode);
                } else {
                    // 如果itemCat表示三级分类 "/products/3.html|电子书",
                    resultList.add("/products/" + cat.getId() + ".html|" + cat.getName());
                }
            }
        }
        return resultList;
    }
}
