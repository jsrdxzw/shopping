package com.natsuki.ego.search.entity;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-14
 * @Description: 封装索引库的查询结果
 */
public class Item {
    @Field("id")
    private String id;
    @Field("title")
    private String title;
    @Field("sell_point")
    private String sellPoint;
    @Field("price")
    private Long price;
    @Field("image")
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

    public String getImage() {
        return image;
    }

    public void setImage(String images) {
        this.image = image;
    }

    public String[] getImages() {
        return image.split(",");
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
