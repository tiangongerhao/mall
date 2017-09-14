package com.test.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yyb on 2017/8/23 0023.
 */
public class Res implements Serializable {
    private int id;
    private String text;
    private String url;
    //创建set集合存放子节点
    private Set<Res> children = new HashSet<Res>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Res() {
    }

    public Res(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public Set<Res> getChildren() {
        return children;
    }

    public void setChildren(Set<Res> children) {
        this.children = children;
    }
}
