package com.ithinksky.designpatterns.ch003behavioral.test002command.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        this.command.Execute();
    }

}
