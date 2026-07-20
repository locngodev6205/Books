package com.example.command;

import com.example.receive.Fan;

/**
 * FanOffCommand – tắt fan.
 * Undo: khôi phục về tốc độ trước khi tắt.
 */
public class FanOffCommand implements Command {

    private Fan fan;
    private int prevSpeed;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.off();
    }

    @Override
    public void undo() {
        switch (prevSpeed) {
            case Fan.HIGH   -> fan.high();
            case Fan.MEDIUM -> fan.medium();
            case Fan.LOW    -> fan.low();
            default         -> fan.off();
        }
    }
}
