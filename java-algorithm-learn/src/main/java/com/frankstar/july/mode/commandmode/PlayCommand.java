package com.frankstar.july.mode.commandmode;


/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class PlayCommand implements Command {

    private AudioPlayer player;

    public PlayCommand(AudioPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}
