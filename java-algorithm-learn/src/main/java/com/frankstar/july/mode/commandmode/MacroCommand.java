package com.frankstar.july.mode.commandmode;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public interface MacroCommand extends Command{

    /**
     * add Command
     * @param command
     */
    public void addCommand(Command command);

    /**
     * remove Command
     * @param command
     */
    public void removeCommand(Command command);
}
