package com.ithinksky.designpatterns.ch002structural.test005facade.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-20
 */
public class Computer implements Component {

    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer() {
        this.cpu = new CPU();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    @Override
    public void start() {
        this.cpu.start();
        this.disk.start();
        this.memory.start();
    }

    @Override
    public void shutDown() {
        this.cpu.shutDown();
        this.memory.shutDown();
        this.disk.shutDown();
    }
}
