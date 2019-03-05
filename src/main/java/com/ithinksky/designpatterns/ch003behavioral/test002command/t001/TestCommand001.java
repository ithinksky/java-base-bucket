package com.ithinksky.designpatterns.ch003behavioral.test002command.t001;

/**
 * 命令模式
 *
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public class TestCommand001 {

    public static void main(String[] args) {

        // 1、控件
        Receiver receiver = new Receiver();

        // 2、控件绑定命令
        Command command = new ConcreteCommand(receiver);

        // 3、执行控件命令
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.executeCommand();
    }

}
