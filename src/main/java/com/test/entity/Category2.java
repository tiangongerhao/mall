package com.test.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yyb on 2017/9/5 0005.
 */
public class Category2 {
    private int id;
    @JSONField(name = "u")
    private  String url="a2.html";
    @JSONField(name = "n")
    private String text;
    private int pid;
    private Set<Category2> i=new HashSet<Category2>();

    public Set<Category2> getI() {
        return i;
    }

    public void setI(Set<Category2> i) {
        this.i = i;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

}
