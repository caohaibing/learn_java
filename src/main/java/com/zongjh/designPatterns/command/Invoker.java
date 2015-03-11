/*
* Copyright (c) 2014 zongjh.com. All Rights Reserved.
*/
package com.zongjh.designPatterns.command;

/**
 * @author: zongjh  Date: 15-2-22 Time: 下午8:33
 * @version: \$Id$
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(){
        command.exec();
    }
}