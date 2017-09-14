package com.test.service;

import com.test.config.FirstDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yyb on 2017/9/12 0012.
 */
@Service
public class FirstService {
    @Resource
    private FirstDao fd;
    public int print(){
        return fd.sum(3,4);
    }
}
