package com.ithinksky.designpatterns.ch003behavioral.test002command.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void Execute();

}
