package com.ikyxxs.adengine.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 */
public class GlobalThreadPool {

    public static ExecutorService executorService =
            new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(1000));
}
