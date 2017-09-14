package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yyb on 2017/9/12 0012.
 */
@Configuration  //相当于一个spring配置文件
public class FirstConfig {
    @Bean   //将创建对象交由spring管理
    public FirstDao createDao(){
        return new FirstDao();
    }
}
