package com.ithinksky.designpatterns.ch002structural.test001adapter.t001;

/**
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
