/*
* Copyright (c) 2014 zongjh.com. All Rights Reserved.
*/
package com.zongjh.designPatterns.command;

/**
 * @author: zongjh  Date: 15-2-22 Time: 下午8:28
 * @version: \$Id$
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exec() {
        receiver.action();
    }
}