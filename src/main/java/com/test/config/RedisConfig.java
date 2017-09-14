package com.test.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yyb on 2017/9/12 0013.
 */
@Configuration
@EnableCaching
public class RedisConfig {
//    @Bean
//    public JedisConnectionFactory createFactory(){
//
//        JedisConnectionFactory factory=new JedisConnectionFactory();
//        factory.setHostName("127.0.0.1");
//        factory.setPort(6379);
//        return  factory;
//    }

}
