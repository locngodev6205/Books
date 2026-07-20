package com.example.command;

import com.example.receive.GarageDoor;

public class GarageDoorUpCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() { garageDoor.up(); }

    @Override
    public void undo()    { garageDoor.down(); }  // undo mở = đóng
}
