package com.example.command;

import com.example.receive.Stereo;

public class StereoOnWithCDCommand implements Command {

    private Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolumn(11);
    }

    @Override
    public void undo() { stereo.off(); }   // undo bật stereo = tắt
}
