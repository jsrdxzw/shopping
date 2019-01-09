package com.natsuki.ego.manager.service.impl;

import com.natsuki.ego.beans.TreeNode;
import com.natsuki.ego.manager.service.ManagerItemCatService;
import com.natsuki.ego.rpc.pojo.TbItemCat;
import com.natsuki.ego.rpc.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-09
 * @Description:
 */
@Service
public class ManagerItemCatServiceImpl implements ManagerItemCatService {

    @Autowired
    private ItemCatService itemCatServiceProxy;

    @Override
    public List<TreeNode> getItemCatList(Long id) {
        List<TbItemCat> itemCatList = itemCatServiceProxy.getItemCatListByParentId(id);
        List<TreeNode> nodeList = new ArrayList<>();

        TreeNode node;
        for (TbItemCat itemCat : itemCatList) {
            node = new TreeNode();
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            node.setState(itemCat.getIsParent()?"closed":"open");
            nodeList.add(node);
        }
        return nodeList;
    }
}
