/*
* Copyright (c) 2014 Qunar.com. All Rights Reserved.
*/
package com.zongjh.concurrent.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zongjh  Date: 15-2-10 Time: 下午11:06
 * @version: \$Id$
 * @see java.util.concurrent.ThreadPoolExecutor
 * 构造方法参数讲解
 * 参数名	作用
 * corePoolSize	核心线程池大小
 * maximumPoolSize	最大线程池大小
 * keepAliveTime	线程池中超过corePoolSize数目的空闲线程最大存活时间；可以allowCoreThreadTimeOut(true)使得核心线程有效时间
 * TimeUnit	keepAliveTime时间单位
 * workQueue	阻塞任务队列
 * threadFactory	新建线程工厂
 * RejectedExecutionHandler	当提交任务数超过maxmumPoolSize+workQueue之和时，任务会交给RejectedExecutionHandler来处理
 */
public class ThreadPoolExecutorLearn {

    public static final int CORE_POOL_SIZE = 10;
    public static final int MAXIMUM_POOL_SIZE = 30;
    public static final int KEEP_ALIVE_TIME = 30;
    /**
     * 定义线程池
     */
    private ThreadPoolExecutor threadPoolExecutor = null;

    public static void main(String[] args) {
        ThreadPoolExecutorLearn pool = new ThreadPoolExecutorLearn();
        pool.init();

        ExecutorService executorService = pool.getThreadPoolExecutor();

        for (int i = 1; i < 100; i++) {
            System.out.println("提交第" + i + "个任务!");
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("running=====");
                }
            });
        }


        // 2.销毁----此处不能销毁,因为任务没有提交执行完,如果销毁线程池,任务也就无法执行了
        // exec.destory();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
    }

    public void init() {
        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(10),
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler());
    }

    public ExecutorService getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    private class CustomThreadFactory implements ThreadFactory {

        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {

            Thread thread = new Thread(r);

            String threadName = ThreadPoolExecutorLearn.class.getSimpleName() + count.addAndGet(1);

            System.out.println(threadName);
            thread.setName(threadName);
            return thread;
        }
    }

    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("error.............");
        }
    }
}