/*
* Copyright (c) 2014 zonjh.com. All Rights Reserved.
*/
package com.zongjh.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 先入先出并且限定容量大小的队列
 *
 * @author: zongjh  Date: 15-2-3 Time: 上午11:12
 * @version: \$Id$
 */
public class ArrayBlockingQueueLearn<E> {

    /**
     * 阻塞队列的容量
     */
    public final static int CAPACITY = 100;
    private final static BlockingQueue queue = new ArrayBlockingQueue(CAPACITY);
    private final static Logger logger = LoggerFactory.getLogger(ArrayBlockingQueueLearn.class);

    /**
     * 增加时候 容器可以容纳，则返回true，否则抛异常
     *
     * @param e
     */
    public boolean add(E e) {

        return queue.add(e);

    }

    /**
     * 从队列中删除头个元素
     *
     * @return
     */
    public E remove() {
        return (E) queue.remove();
    }

    /**
     * 如果队列中可以容纳，返回true 否则返回false
     *
     * @param e
     */
    public boolean offer(E e) {
        return queue.offer(e);
    }

    /**
     * 如果队列中可以容纳，返回true 否则返回false
     * 设置超时时间
     *
     * @param e
     * @param time
     * @param timeUnit
     */
    public boolean offer(E e, long time, TimeUnit timeUnit) {
        try {
            return queue.offer(e, time, timeUnit);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        return false;
    }

    /**
     * 从队列中移除
     *
     * @return
     */
    public E poll() {
        return (E) queue.poll();
    }




}