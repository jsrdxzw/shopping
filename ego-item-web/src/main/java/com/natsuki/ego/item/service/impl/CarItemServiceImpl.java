package com.natsuki.ego.item.service.impl;

import com.natsuki.ego.beans.JsonUtils;
import com.natsuki.ego.item.dao.CarItemDao;
import com.natsuki.ego.item.entity.CarItem;
import com.natsuki.ego.item.service.CarItemService;
import com.natsuki.ego.rpc.pojo.TbItem;
import com.natsuki.ego.rpc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-17
 * @Description:
 */
@Service
public class CarItemServiceImpl implements CarItemService {

    @Autowired
    private CarItemDao carItemDao;

    @Autowired
    private ItemService itemServiceProxy;

    @Override
    public void addItemToCar(Long itemId, Long uid) {

        Map<String, String> carMap;
        CarItem carItem;

        //获得商品对象
        TbItem tbItem = itemServiceProxy.selectTbItem(itemId);


        //判断用户是否第一次购物，或者是判断是否已经存在carMap
        carMap = carItemDao.getCarMap(String.valueOf(uid));
        if (carMap == null) {
            //创建Map集合对象
            carMap = new HashMap<>(16);
        }

        //判断itemid对象的商品是否存在一个购物车对象
        String carItemStr = carItemDao.getCarItem(String.valueOf(uid), String.valueOf(itemId));
        if (StringUtils.isEmpty(carItemStr)) {
            //创建购物车对象
            carItem = new CarItem();
            //将商品信息放入到购物车
            carItem.setItem(tbItem);
            carItem.setNum(1);
        } else {
            carItem = JsonUtils.jsonToPojo(carItemStr, CarItem.class);
            //修改购物车数量
            if (carItem != null) {
                carItem.setNum(carItem.getNum() + 1);
            }
        }

        //将购物车对象转化为json字符串
        String jsonStr = JsonUtils.objectToJson(carItem);
        //购物车对象放入map集合
        carMap.put(String.valueOf(itemId), jsonStr);

        //将carMap集合保存到redis数据库
        carItemDao.saveCarMap(String.valueOf(uid), carMap);
    }

    @Override
    public Map<Long, CarItem> getCarItemList(Long uid) {
        Map<Long, CarItem> carMap = new HashMap<>(16);
        // 获得某个用户的购物车列表
        Map<String, String> carMapStr = carItemDao.getCarMap(String.valueOf(uid));
        if (!StringUtils.isEmpty(carMapStr)) {
            for (Map.Entry<String, String> e : carMapStr.entrySet()) {

                String key = e.getKey();
                String value = e.getValue();
                //将value字符串，转化为CarItem对象
                CarItem carItem = JsonUtils.jsonToPojo(value, CarItem.class);

                carMap.put(Long.parseLong(key), carItem);
            }
        }
        return carMap;
    }

    @Override
    public String updateCarItemNum(Long itemId, Long uid, Integer num) {
        try {
            String carItemStr = carItemDao.getCarItem(String.valueOf(uid), String.valueOf(itemId));
            CarItem carItem = JsonUtils.jsonToPojo(carItemStr, CarItem.class);
            if (carItem != null) {
                carItem.setNum(num);
                carItemDao.updateCarMapNum(String.valueOf(uid),String.valueOf(itemId),JsonUtils.objectToJson(carItem));
            }
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
