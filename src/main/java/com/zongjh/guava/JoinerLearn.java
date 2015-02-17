/*
* Copyright (c) 2014 zongjh.com. All Rights Reserved.
*/
package com.zongjh.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author: zongjh  Date: 15-2-14 Time: 下午8:36
 * @version: \$Id$
 */
public class JoinerLearn {

    public static void main(String[] args) {

        // 将list中的元素按照逗号连接，并且过滤null值
        Joiner joiner = Joiner.on(",").skipNulls();
        System.out.println(joiner.join(Lists.newArrayList("test", null, "test1", "test2")));

        // 将list中的元素按照逗号连接，并且将null的值使用默认的haha
        Joiner joiner1 = Joiner.on(",").useForNull("haha");
        System.out.println(joiner1.join(Lists.newArrayList("test", null, "test1", "test2")));

        StringBuilder test = new StringBuilder("ceshi");
        test.append("dsdssd");

        StringBuilder stringBuilder = Joiner.on(",").appendTo(test, Lists.newArrayList("test", null, "test1", "test2"));
        System.out.println(stringBuilder);
    }
}