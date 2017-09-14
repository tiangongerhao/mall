package com.test.controller;

import com.test.dao.CommoDao;
import com.test.entity.Category;
import com.test.entity.Commodity;
import com.test.util.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by yyb on 2017/8/30 0030.
 */
@Controller
public class CartController {
//    注入
    @Resource
    private CommoDao cd;
    @RequestMapping("toCart.do")
    @ResponseBody
    public String toCart(String id,HttpSession session){
        System.out.println(id);
        Commodity commo=cd.findCommoById(id);
        Cart cart = (Cart) session.getAttribute("cart");
        //第一次购买
        if (cart==null){
            cart=new Cart();
            session.setAttribute("cart",cart);
        }
        //将商品放入购物车
        cart.addCommo(commo);
        return "redirect:cart.jsp";
    }

    @RequestMapping("deleteCart.do")
    @ResponseBody
    public String deleteCart(String id,HttpSession session){
        Commodity commo=cd.findCommoById(id);
        Cart cart = (Cart) session.getAttribute("cart");

        //删除指定商品
        cart.deleteCart(id);
        return "redirect:main.jsp";
    }
}
