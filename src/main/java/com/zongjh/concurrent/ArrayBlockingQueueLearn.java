/*
* Copyright (c) 2014 Qunar.com. All Rights Reserved.
*/
package com.zongjh.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
    public static final int CAPACITY = 100;
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
     * 从
     *
     * @return
     */
    public E remove() {
        return (E) queue.remove();
    }

}