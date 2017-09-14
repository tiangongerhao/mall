package com.test.controller;

import com.test.dao.CommoDao;
import com.test.entity.Commodity;
import com.test.util.KeysUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yyb on 2017/8/28 0028.
 */
@Controller
public class CommodityController {
    @Resource
    private CommoDao cd;

    @RequestMapping("addCommo.do")
    @ResponseBody
    public String addCommo(Commodity commodity){
        commodity.setId(KeysUtils.createId());
        cd.addCommo(commodity);
        System.out.println("aaaaaaaaa");
        return "1";
    }
    //所有的商品
    @RequestMapping("findAllCommo.do")
    @ResponseBody
    public List<Commodity> findAllCommo() {
        System.out.println("123");
        return cd.findAllCommo();
    }
    @RequestMapping("portal.do")
    public String portal(HttpSession session){
//       System.out.println("123");
        List<Commodity> commos=cd.findAllCommo();
        session.setAttribute("commos",commos);
//        System.out.println("aaaaaaaa");
        return "portal";
    }
    @RequestMapping("findTotal.do")
    @ResponseBody
    public String findTotal(){
        Map<String,Float> data=new HashMap<String, Float>();
        data.put("x",5000f);
        cd.findTotal(data);
        return ""+data.get("y");
    }
}
