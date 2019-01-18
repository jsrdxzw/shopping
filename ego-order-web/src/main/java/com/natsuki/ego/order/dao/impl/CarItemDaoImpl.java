package com.natsuki.ego.order.dao.impl;

import com.natsuki.ego.order.dao.CarItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;

import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-18
 * @Description:
 */
@Repository
public class CarItemDaoImpl implements CarItemDao {

    @Autowired
    private JedisCluster jedisCluster;


    @Override
    public Map<String, String> getCarItemMap(String uid) {
        return jedisCluster.hgetAll(uid);
    }

    @Override
    public void deleteCarItemMap(String uid) {
        jedisCluster.del(uid);
    }
}
