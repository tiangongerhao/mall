package com.test.entity;

import java.io.Serializable;

/**
 * Created by yyb on 2017/8/28 0028.
 */
public class Commodity implements Serializable {
    private String id;
    private String name;
    private int categoryid;
    private String content;
    private int num;//购买商品的数量
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Commodity() {
    }

    public Commodity(String id, String name, int categoryid, String content, int num, float price) {
        this.id = id;
        this.name = name;
        this.categoryid = categoryid;
        this.content = content;
        this.num = num;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
