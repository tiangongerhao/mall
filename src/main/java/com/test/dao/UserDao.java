package com.test.dao;

import com.test.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/22.
 */
@Repository
public interface UserDao {
    User login(User u);
    //读取所有用户
    List<User> findAllUser(Map<String,Integer> data);
    //添加用户
    void editUser(User user);
    void addUser(User user);
    void deleteUser2(int id);
    void deleteUser(ArrayList<Integer> ids);
}
