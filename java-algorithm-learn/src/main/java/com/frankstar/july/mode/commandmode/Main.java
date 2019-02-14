package com.frankstar.july.mode.commandmode;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class Main {

    public static void main(String[] args) {

        AudioPlayer player = new AudioPlayer();

        Command play = new PlayCommand(player);

        Command pause = new PauseCommand(player);

        Command rewind = new RewindCommand(player);

        Command stop = new StopCommand(player);

        Invoker invoker = new Invoker();
        invoker.setPauseCommand(pause);
        invoker.setPlayCommand(play);
        invoker.setRewindCommand(rewind);
        invoker.setStopCommand(stop);

        invoker.play();
        invoker.pause();
        invoker.rewind();
        invoker.stop();


        System.out.println("==============");

        MacroCommand macroCommand = new MacroAudioCommand();
        macroCommand.addCommand(play);
        macroCommand.addCommand(pause);
        macroCommand.addCommand(rewind);
        macroCommand.addCommand(stop);

        macroCommand.execute();

    }
}
