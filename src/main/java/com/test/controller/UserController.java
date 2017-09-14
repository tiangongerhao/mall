package com.test.controller;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.util.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/22.
 */
//控制层
@Controller
public class UserController {
    @Resource  //注入userdao
    private UserDao ud;
    @RequestMapping("toLogin.do")
    public String toLogin(){
        return "redirect:login.html";
    }
    @RequestMapping("login2.do")
    public String login2(User user, HttpSession session){
        String s=SecurityUtil.md5Encrpt(user.getPwd());
        user.setPwd(s);
        //调用dao层的方法
        User u=ud.login(user);
        System.out.println(u+"===========");
        if (u!=null){
//            System.out.println("ggggggggggggg");
            session.setAttribute("user",u);
        }
        return "success";
    }
    @RequestMapping("login.do")
    public String login(User user){
        String s=SecurityUtil.md5Encrpt(user.getPwd());
        user.setPwd(s);
        //主体
        Subject subject= SecurityUtils.getSubject();
        //令牌
        UsernamePasswordToken token=new UsernamePasswordToken(user.getAccount(),user.getPwd());
        subject.login(token);
        //给属性赋值
        user.setId(10);
        //将user放入shiro的session中
        subject.getSession().setAttribute("user",user);
        return "main";
    }
    //添加退出时的执行方法
    @RequestMapping("logout.do")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        //退出
        subject.logout();
        return toLogin();
    }
    @RequestMapping("toNoQX")
    public String toNoQX(){
        return "redirect:noqx.jsp";
    }

    @RequestMapping("findAllUser.do")
    //
    @RequiresPermissions(value = {"user:query"})
    @ResponseBody
    public List<User> findAllUser(int page,int size){
        Map<String,Integer> data= new HashMap<String, Integer>();
        //将页码转换为数据起点
        data.put("start",(page-1)*size);
        data.put("size2",size);
        return ud.findAllUser(data);
    }
    @RequestMapping("adduser.do")
    @ResponseBody
    public String addUser(User user){
        System.out.println(user.getId()+"=====userid");
        if (user.getId()==0){
            //对密码加密
            String s = SecurityUtil.md5Encrpt(user.getPwd());
            user.setPwd(s);
            ud.addUser(user);
        }else {
            ud.editUser(user);
        }
       return "1";
    }
//    删除多个用户
    @RequestMapping("deleteUser.do")
    @ResponseBody
    //泛型的数据类型必须写成引用类型int-->Integer
    public String deleteUser(@RequestBody ArrayList<Integer> ids){
        ud.deleteUser(ids);
        return "1";
    }
//    删除一个数据
    @RequestMapping("deleteUser2.do")
    @ResponseBody
    public String deleteUser2(int id){
        ud.deleteUser2(id);
        return "1";
    }
}





















