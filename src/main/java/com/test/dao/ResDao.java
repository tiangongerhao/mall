package com.test.dao;

import com.test.entity.Res;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by yyb on 2017/8/23 0023.
 */
@Repository
public interface ResDao {
    //返回所有模块
    List<Res> findAllRes(int uid);
    List<Res> findAllResForPerm();
    void fenp(Map<String,Object> data);
    void deletep(int userid);
}
