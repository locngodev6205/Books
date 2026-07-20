package com.example.invoker;

import com.example.command.Command;
import com.example.command.NoCommand;

public class RemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;
    private Command   lastCommandInvoked;   // ← ghi nhớ lệnh cuối để undo

    public RemoteControl() {
        onCommands  = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i]  = noCommand;
            offCommands[i] = noCommand;
        }
        lastCommandInvoked = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot]  = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onPressButton(int slot) {
        onCommands[slot].execute();
        lastCommandInvoked = onCommands[slot];
    }

    public void offPressButton(int slot) {
        offCommands[slot].execute();
        lastCommandInvoked = offCommands[slot];
    }

    public void undoPressButton() {
        System.out.println("-- [UNDO] --");
        lastCommandInvoked.undo();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot ").append(i).append("] ")
              .append(onCommands[i].getClass().getSimpleName())
              .append("   ")
              .append(offCommands[i].getClass().getSimpleName())
              .append("\n");
        }
        return sb.toString();
    }
}
