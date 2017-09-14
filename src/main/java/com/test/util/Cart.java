package com.test.util;

import com.test.entity.Commodity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yyb on 2017/8/30 0030.
 */
//购物车类
public class Cart {
    Map<String,Commodity> data=new HashMap<String, Commodity>();
    //添加商品
    public void addCommo(Commodity c){
        //第一次购买某商品
        if (!data.containsKey(c.getId())){
            c.setNum(1);
            data.put(c.getId(),c);
        }else {
            Commodity commodity=data.get(c.getId());
            commodity.setNum(commodity.getNum()+1);
        }
    }
    //读取所有已经购买的商品
    public Collection<Commodity> show(){
        return data.values();
    }
    //计算总价
    public float total(){
        float x=0;
        Collection<Commodity> vas=data.values();
        for (Commodity c:vas){
            x=x+c.getPrice()*c.getNum();
        }
        return x;
    }
    //删除，
    public void deleteCart(String id) {
        data.remove(id);
    }
}
