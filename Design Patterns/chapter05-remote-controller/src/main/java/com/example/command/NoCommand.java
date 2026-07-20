package com.example.command;

public class NoCommand implements Command {

    @Override
    public void execute() {}

    @Override
    public void undo() {}   // no-op
}
