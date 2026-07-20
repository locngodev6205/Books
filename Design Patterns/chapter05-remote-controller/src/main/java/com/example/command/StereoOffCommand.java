package com.example.command;

import com.example.receive.Stereo;

public class StereoOffCommand implements Command {

    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() { stereo.off(); }

    @Override
    public void undo() {                    // undo tắt = bật lại với CD
        stereo.on();
        stereo.setCD();
        stereo.setVolumn(11);
    }
}
