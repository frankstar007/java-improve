package com.frankstar.july.mode.commandmode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class MacroAudioCommand implements MacroCommand {

    private List<Command> commands = new ArrayList<>();

    /**
     * execute
     */
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    /**
     * @param command
     */
    @Override
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     * @param command
     */
    @Override
    public void removeCommand(Command command) {
        commands.remove(command);
    }
}
