package com.test.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/**
 * Created by yyb on 2017/9/13 0013.
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
    @Bean
    public HttpMessageConverters createConvert(){
        FastJsonHttpMessageConverter converter=new FastJsonHttpMessageConverter();
        FastJsonConfig config=new FastJsonConfig();
        //美化json格式
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        converter.setFastJsonConfig(config);
        return new HttpMessageConverters(converter);
    }
    //定义key的生成策略
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //使用类名+方法名+参数作为key
                StringBuilder sd=new StringBuilder();
                //类名
                sd.append(o.getClass().getName());
                //方法
                sd.append(method.getName());
                for(Object x:objects){
                    sd.append(x);
                }
                return sd.toString();
            }
        };
    }
    @Bean
    public RedisTemplate<Object,Object> createTem(RedisConnectionFactory factory){
        RedisTemplate<Object,Object> template=new RedisTemplate<Object, Object>();
        template.setConnectionFactory(factory);
        //指定key的序列化方式
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new FastJsonSerializer<Object>(Object.class));
        template.afterPropertiesSet();
        return  template;
    }
    @Bean
    public RedisCacheManager createCM(RedisTemplate<Object,Object> redisTemplate){
        RedisCacheManager cm=new RedisCacheManager(redisTemplate);
//        cm.setDefaultExpiration(60);//60s:60秒后redis中的数据自动清除
        return  cm;
    }
    //使用fastjson实现序列化
    //泛型:以类型作为参数

    class  FastJsonSerializer<T> implements RedisSerializer<T> {
        private Class<T>  ct;
        public FastJsonSerializer(Class<T> t2){
            this.ct=t2;
            System.out.println("aaaaaaaaaaaaaaaaa");
        }
        @Override
        public byte[] serialize(T t) throws SerializationException {
            System.out.println("bbbbbbbbbbbbbbbbbb");
            try {
                return   JSON.toJSONString(t).getBytes("utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public T deserialize(byte[] bytes) throws SerializationException {
            try {
                String s=new String(bytes,"utf-8");
                return  JSON.parseObject(s,ct);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
