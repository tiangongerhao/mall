package com.test.controller;

import com.test.dao.ResDao;
import com.test.entity.Res;
import com.test.entity.User;
import com.test.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyb on 2017/8/23 0023.
 */
@Controller
public class ResController {
    @Autowired
    private ResDao rd;
    @Resource
    private ResService rs;
    //所有模块
    @RequestMapping("findAllRes.do")
    @ResponseBody
    public List<Res> findAllRes(HttpSession session) {
        //取出当前登录的用户
        User user = (User) session.getAttribute("user");
        System.out.println("--"+user.getId());
//        System.out.println("123");
        return rd.findAllRes(user.getId());
    }
    @RequestMapping("findAllResForPerm.do")
    @ResponseBody
    public List<Res> findAllResForPerm(){
        List<Res> rs = rd.findAllResForPerm();
        return rs;
    }
    @RequestMapping("fenp.do")
    @ResponseBody
    public String fenp(@RequestBody ArrayList<Integer> data){
        try {
            rs.fenp(data);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }
}








