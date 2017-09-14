package com.test.entity;

import java.io.Serializable;

/**
 * Created by yyb on 2017/8/29 0029.
 */
public class Images implements Serializable {
    private String id;
    private String path;
    private String createTime;
    private String commodityId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public Images() {
    }

    public Images(String id, String path, String createTime, String commodityId) {
        this.id = id;
        this.path = path;
        this.createTime = createTime;
        this.commodityId = commodityId;
    }
}
