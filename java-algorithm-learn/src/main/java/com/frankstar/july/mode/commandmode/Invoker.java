package com.frankstar.july.mode.commandmode;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class Invoker {

    private Command playCommand;

    private Command pauseCommand;

    private Command rewindCommand;

    private Command stopCommand;

    public void setPlayCommand(Command playCommand) {
        this.playCommand = playCommand;
    }

    public void setPauseCommand(Command pauseCommand) {
        this.pauseCommand = pauseCommand;
    }

    public void setRewindCommand(Command rewindCommand) {
        this.rewindCommand = rewindCommand;
    }

    public void setStopCommand(Command stopCommand) {
        this.stopCommand = stopCommand;
    }

    /**
     * play method
     */
    public void play() {
        playCommand.execute();
    }

    /**
     * pause method
     */
    public void pause() {
        pauseCommand.execute();
    }

    /**
     * rewind method
     */
    public void rewind() {
        rewindCommand.execute();
    }

    /**
     * stop method
     */
    public void stop() {
        stopCommand.execute();
    }
}
