package com.test.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yyb on 2017/9/5 0005.
 */
public class Category implements Serializable{
    private int id;
    private String text;
    private int pid;
    private Set<Category> chlidren=new HashSet<Category>();

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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Set<Category> getChlidren() {
        return chlidren;
    }

    public void setChlidren(Set<Category> chlidren) {
        this.chlidren = chlidren;
    }
}
