package com.natsuki.ego.beans;

import java.util.Random;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-10
 * @Description: 生成id的工具类
 */
public class IDUtils {


    /**
     * @return 图片名字
     */
    public static String genImageName(){
        long millis = System.currentTimeMillis();
        Random random = new Random();
        int end3 = random.nextInt(1000);
        //补0
        return millis + String.format("%03d",end3);
    }

    /**
     * @return 商品的id
     */
    public static long genItemId(){
        long millis = System.currentTimeMillis();
        Random random = new Random();
        int end2 = random.nextInt(100);
        //补0
        return new Long(millis + String.format("%02d",end2));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(genItemId());
        }
    }
}
