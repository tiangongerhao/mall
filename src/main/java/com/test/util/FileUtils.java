package com.test.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yyb on 2017/8/29 0029.
 */
public class FileUtils {
    //线程池
    public static ExecutorService pool;
    static{
        pool= Executors.newFixedThreadPool(5);
    };
}
