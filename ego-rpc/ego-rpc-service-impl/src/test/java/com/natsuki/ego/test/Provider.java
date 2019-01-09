package com.natsuki.ego.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-08
 * @Description: 发布服务, dubbo
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml",
                "spring/applicationContext-service.xml", "spring/applicationContext-tx.xml", "spring/applicationContext-dubbo.xml");
        applicationContext.start();
        System.in.read();
        applicationContext.stop();
    }
}
