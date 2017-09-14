package com.test.service;

import com.test.dao.CategoryDao;
import com.test.entity.Category2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyb on 2017/9/5 0005.
 */
@Service
public class CategoryService {
    @Resource
    private CategoryDao cd;
    public List<Category2> findAllCategoryForPortal(){
        List<Category2> rs=cd.findAllCategoryForPortal();
        //复制集合
        List<Category2> rs2=new ArrayList<Category2>();
        rs2.addAll(rs);
        List<Category2> data=new ArrayList<Category2>();
        //创建父子关系
        for (Category2 a:rs){
            if (a.getPid()==0){
                data.add(a);
            }
            for (Category2 b:rs2){
                if (b.getPid()==a.getId()){
                    a.getI().add(b);
                }
            }
        }
        return data;
    }
}
