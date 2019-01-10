package com.natsuki.ego.beans;

import java.io.Serializable;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-09
 * @Description: 封装上传图片之后的返回结果
 */
public class PictureResult implements Serializable {


    /**
     * 状态码
     */
    private Integer error;

    /**
     * 图片在服务器上的url
     */
    private String url;
    private String message;

    public PictureResult(Integer error, String url, String message) {
        this.error = error;
        this.url = url;
        this.message = message;
    }

    public PictureResult() {
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
