package com.test.config;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/* Created by yyb on 2017/9/12 0012.
 */
@Configuration//spring容器
public class FirstConfig {
    @Bean
    public JdbcRealm createRealm(){
        System.out.println("-------创建了realm对象");
        JdbcRealm realm =new JdbcRealm();
        realm.setPermissionsLookupEnabled(true);
        realm.setAuthenticationQuery("select pwd from users where account=?");
        realm.setUserRolesQuery("select role_name from user_role left join users u using(id) left join roles using(rid) where u.account=?");
        realm.setPermissionsQuery("select perms from role_res left join roles r using(rid) left join res using(id) where r.role_name=?");
        return realm;
    }
    //缓存管理器
    @Bean
    public CacheManager createCM(){
        return new MemoryConstrainedCacheManager();
    }
//    @Bean//注入参数
//    public DefaultWebSecurityManager reateSM(JdbcRealm realm, MemoryConstrainedCacheManager sm){
//        DefaultWebSecurityManager dsm=new DefaultWebSecurityManager();
//        dsm.setRealm(realm);
//        dsm.setCacheManager(sm);
//        System.out.println("-------------注入了参数");
//        return  dsm;
//    }
    //保护页面
//    @Bean
//    public ShiroFilterFactoryBean createFilter(DefaultWebSecurityManager ab){
//        ShiroFilterFactoryBean fb=new ShiroFilterFactoryBean();
//        fb.setSecurityManager(ab);
//        fb.setLoginUrl("/login.html");
//        Map<String,String> s=new HashMap<>();
//        s.put("/login.html","anon");
//        s.put("/js*","anon");
//        s.put("/css*","anon");
//        s.put("/login.do","anon");
//        s.put("*","authc");
//        fb.setFilterChainDefinitionMap(s);
//        return  fb;
//    }
}
