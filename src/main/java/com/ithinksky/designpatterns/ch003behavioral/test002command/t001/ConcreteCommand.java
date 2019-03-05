package com.ithinksky.designpatterns.ch003behavioral.test002command.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-21
 */
public class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void Execute() {
        super.receiver.action();
    }
}
