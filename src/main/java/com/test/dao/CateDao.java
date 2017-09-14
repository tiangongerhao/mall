package com.test.dao;

import com.test.entity.Category;
import com.test.entity.Category2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yyb on 2017/8/28 0028.
 */
@Repository
public interface CateDao  {
    List<Category> FindAllCate();
    @Cacheable(value = "findAllCate2")
    List<Category> findAllCate2();
    //添加数据时，重建指定key的缓存
    @CacheEvict(value = "findAllCate2",allEntries = true)
    void addCate(Category category);
    List<Category2> findAllCategoryForPortal();
}
