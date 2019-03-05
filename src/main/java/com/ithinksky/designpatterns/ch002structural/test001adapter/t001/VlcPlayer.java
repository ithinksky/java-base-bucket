package com.ithinksky.designpatterns.ch002structural.test001adapter.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
