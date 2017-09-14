package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.dao.CateDao;
import com.test.entity.Category;
import com.test.entity.Category2;
import com.test.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by yyb on 2017/8/28 0028.
 */
@Controller
public class CategoryController {
    @Resource
    private CateDao cd;//注入依赖的资源
    @Resource
    private CategoryService cs;
    //有父子关系的
    @RequestMapping("FindAllCate.do")
    @ResponseBody
    public List<Category> FindAllCate(){
         return cd.FindAllCate();
    }
    //无父子关系的
    @RequestMapping("findAllCate2.do")
    @ResponseBody
    public Map findAllCate2(){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",1);
        map.put("rows",cd.findAllCate2());
        return map;
    }
    @RequestMapping(value = "addCate.do")
    @ResponseBody
    public  String addCate(Category category){
        cd.addCate(category);
        return "1";
    }
//    给前台页面供应类别数据
    @RequestMapping(value = "findAllCategoryForPortal.do",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String findAllCategoryForPortal(){
        List<Category2> data=cs.findAllCategoryForPortal();
        String json= JSON.toJSONString(data);
        String rs="category.getDataService({\"data\":"+json+"})";
        return rs;
    }
}
