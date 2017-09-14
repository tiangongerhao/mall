package com.test.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yyb on 2017/8/23 0023.
 * 加密数据
 */
public class SecurityUtil {
    //md5加密
    public static String md5Encrpt(String value){
        StringBuilder sd=new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(value.getBytes());
//            加密
            byte[] target = md5.digest();
//            转化为string
            for (int i = 0; i <target.length ; i++) {
                int x=(int) target[i]&0xff;
                //“加盐”对加密之后的文件再加密
                x=x+1;
                if (x<16){
                    sd.append(0);
                }
                sd.append(Integer.toHexString(x));
            }
//            System.out.println(sd.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sd.toString();
    }

    public static void main(String[] args) {
        md5Encrpt("abc");
    }
}





