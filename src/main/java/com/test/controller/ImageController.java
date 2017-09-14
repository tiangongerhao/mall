package com.test.controller;


import com.test.dao.ImageDao;
import com.test.entity.Images;
import com.test.util.KeysUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * Created by yyb on 2017/8/29 0029.
 */
@Controller
public class ImageController{
    @Resource
    private ImageDao md;
    @RequestMapping("upload.do")
    @ResponseBody
    public String upLoadImage(@RequestParam("ff")final MultipartFile file, @RequestParam Map<String,String> data){
        //上传文件名称
        String filename=file.getOriginalFilename();
        final String path="d:/image/"+filename;
        //通过线程池启动一个线程保存文件
        com.test.util.FileUtils.pool.execute(new Runnable() {
            public void run() {
                try {
                    //保存上传的文件
                    file.transferTo(new java.io.File(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
      /* FileUtils.pool.execute(new Runnable(){
        在此处因为导包问题而出错
       });*/
      //存入数据库
        Images img=new Images();
        img.setId(KeysUtils.createId());
        img.setPath(path);
        img.setCommodityId(data.get("commodityId"));
        md.saveImage(img);
       return "aaaaaaa";
    }
}






