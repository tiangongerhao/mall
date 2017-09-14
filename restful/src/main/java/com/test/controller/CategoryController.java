package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.service.CategoryService;
import com.test.entity.Category2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yyb on 2017/9/5 0005.
 */
@Controller
public class CategoryController {
    @Resource
    private CategoryService cs;
    //给前台页面提供类别数据
    @RequestMapping(value = "findAllCategoryForPortal.do",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String findAllCategoryForPortal(){
        List<Category2> data =cs.findAllCategoryForPortal();
        String json= JSON.toJSONString(data);
        String rs="category.getDataService({\"data\":"+json+"})";
        System.out.println("789");
        return rs;
    }

}
