package com.test.dao;

import com.test.entity.Commodity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by yyb on 2017/8/28 0028.
 */
@Repository
public interface CommoDao {
    List<Commodity> findAllCommo();
    void addCommo(Commodity commodity);
    void deleteCart(Commodity commodity);
    Commodity findCommoById(String id);
    void findTotal(Map<String,Float> data);
}
