package com.test.dao;

import com.test.entity.Category2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yyb on 2017/9/5 0005.
 */
@Repository
@Mapper
public interface CategoryDao {
    List<Category2> findAllCategory();
    @Cacheable (value = "aaa999")
    List<Category2> findAllCategoryForPortal();
}



















