package com.natsuki.ego.search.entity;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-14
 * @Description: 封装索引库的查询结果
 */
public class Item {
    private String id;
    private String title;
    @Field("sell_point")
    private String sellPoint;
    private Long price;
    private String image;
    @Field("category_name")
    private String categoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String[] getImage() {
        return image.split(",");
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
