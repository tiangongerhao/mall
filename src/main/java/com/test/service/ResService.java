package com.test.service;

import com.test.dao.ResDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yyb on 2017/9/8 0008.
 */
@Service
public class ResService {
    @Resource
    private ResDao rd;
    @Transactional
    public void fenp(ArrayList<Integer> data){
        int userid=data.get(0);
        rd.deletep(userid);
        //删除userid
        data.remove(0);
        Map<String,Object> params=new HashMap<String, Object>();
        params.put("userid",userid);
        params.put("resids",data);
        rd.fenp(params);
    }
}
