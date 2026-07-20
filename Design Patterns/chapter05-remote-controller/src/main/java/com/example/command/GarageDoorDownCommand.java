package com.example.command;

import com.example.receive.GarageDoor;

public class GarageDoorDownCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() { garageDoor.down(); }

    @Override
    public void undo()    { garageDoor.up(); }   // undo đóng = mở
}
