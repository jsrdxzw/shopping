package com.natsuki.ego.item.dao.impl;

import com.natsuki.ego.item.dao.CarItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisCluster;

import java.util.Map;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-17
 * @Description:
 */
@Repository
public class CarItemDaoImpl implements CarItemDao {

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public void saveCarMap(String uid, Map<String, String> carMap) {
        jedisCluster.hmset(uid, carMap);
    }

    @Override
    public Map<String, String> getCarMap(String uid) {
        return jedisCluster.hgetAll(uid);
    }

    @Override
    public String getCarItem(String uid, String itemId) {
        return jedisCluster.hget(uid, itemId);
    }

    @Override
    public void updateCarMapNum(String uid, String itemId, String carItem) {
        jedisCluster.hset(uid,itemId,carItem);
    }
}
