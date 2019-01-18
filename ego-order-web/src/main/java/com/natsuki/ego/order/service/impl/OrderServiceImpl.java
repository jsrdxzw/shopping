package com.natsuki.ego.order.service.impl;

import com.natsuki.ego.beans.JsonUtils;
import com.natsuki.ego.order.dao.CarItemDao;
import com.natsuki.ego.order.entity.CarItem;
import com.natsuki.ego.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-18
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CarItemDao carItemDao;


    @Override
    public Map<Long, CarItem> getCarItemMap(Long id) {
        Map<String, String> carItemMap = carItemDao.getCarItemMap(String.valueOf(id));
        Map<Long, CarItem> carMap = new HashMap<>(16);

        for (Map.Entry<String, String> entry : carItemMap.entrySet()) {
            carMap.put(Long.valueOf(entry.getKey()), JsonUtils.jsonToPojo(entry.getValue(), CarItem.class));
        }
        return carMap;
    }
}
