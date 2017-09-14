package com.test.util;

import java.util.UUID;

/**
 * Created by yyb on 2017/8/29 0029.
 */
public class KeysUtils {
    //生成一个惟一的表示符
    public synchronized static String createId() {
        UUID uuid=UUID.randomUUID();
        String x=uuid.toString();
        String y=x.replaceAll("-","");
        long time=System.currentTimeMillis();
        return y+time;
    }
    public static void main(String[] args) {

    }
}