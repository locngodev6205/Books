package com.example.command;

import com.example.receive.Fan;

/**
 * FanOnCommand – bật fan HIGH.
 * Undo: khôi phục về tốc độ trước đó.
 */
public class FanOnCommand implements Command {

    private Fan fan;
    private int prevSpeed;   // lưu tốc độ trước khi execute

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();  // ghi nhớ tốc độ hiện tại
        fan.high();
    }

    @Override
    public void undo() {
        // khôi phục về tốc độ trước execute
        switch (prevSpeed) {
            case Fan.HIGH   -> fan.high();
            case Fan.MEDIUM -> fan.medium();
            case Fan.LOW    -> fan.low();
            default         -> fan.off();
        }
    }
}
