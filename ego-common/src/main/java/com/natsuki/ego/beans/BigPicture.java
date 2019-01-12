package com.natsuki.ego.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-12
 * @Description: 大广告,响应到前端数据
 */
public class BigPicture {
    @JsonProperty("srcB")
    private String srcb;

    private Integer height=240;

    private String alt;
    private Integer width = 670;
    private String src;
    @JsonProperty("widthB")
    private Integer widthb=550;
    private String href;
    @JsonProperty("heightB")
    private Integer heightb = 240;

    public String getSrcb() {
        return srcb;
    }

    public void setSrcb(String srcb) {
        this.srcb = srcb;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidthb() {
        return widthb;
    }

    public void setWidthb(Integer widthb) {
        this.widthb = widthb;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getHeightb() {
        return heightb;
    }

    public void setHeightb(Integer heightb) {
        this.heightb = heightb;
    }
}
