package com.ithinksky.designpatterns.ch002structural.test001adapter.t001;

/**
 * 适配器模式:
 * 对于系统重构意义重大
 * 注意衡量重构和重写之间的代价
 *
 * @author tengpeng.gao
 * @since 2019-02-16
 */
public class TestAdapter001 {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }

}
