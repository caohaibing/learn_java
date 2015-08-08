/*
* Copyright (c) 2015 Qunar.com. All Rights Reserved.
*/
package com.zongjh.apache.commons;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author: zongjh  Date: 15-4-13 Time: 下午8:01
 * @version: \$Id$
 */
public class Command3 implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("command2 is done");
        return false;
    }
}