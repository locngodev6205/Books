package com.example;

import com.example.command.*;
import com.example.invoker.RemoteControl;
import com.example.receive.*;

public class App {
    public static void main(String[] args) {

        Light       livingRoomLight = new Light();
        Fan         livingRoomFan   = new Fan();
        GarageDoor  garageDoor      = new GarageDoor();
        Stereo      stereo          = new Stereo();

        Command lightOn   = new LightOnCommand(livingRoomLight);
        Command lightOff  = new LightOffCommand(livingRoomLight);
        Command fanOn     = new FanOnCommand(livingRoomFan);
        Command fanOff    = new FanOffCommand(livingRoomFan);
        Command garageUp  = new GarageDoorUpCommand(garageDoor);
        Command garageDown= new GarageDoorDownCommand(garageDoor);
        Command stereoOn  = new StereoOnWithCDCommand(stereo);
        Command stereoOff = new StereoOffCommand(stereo);

        RemoteControl remote = new RemoteControl();
        // remote.setCommand(0, lightOn,  lightOff);
        // remote.setCommand(1, fanOn,    fanOff);
        // remote.setCommand(2, garageUp, garageDown);
        // remote.setCommand(3, stereoOn, stereoOff);

        // System.out.println(remote);

        // // ── Undo Light ────────────────────────────────────────────────────────
        // System.out.println("=== Light ===");
        // remote.onPressButton(0);          // Light ON
        // remote.undoPressButton();         // → Light OFF

        // // ── Undo Fan (với speed levels) ───────────────────────────────────────
        // System.out.println("\n=== Fan ===");
        // remote.onPressButton(1);          // Fan HIGH
        // remote.undoPressButton();         // → Fan OFF (về trạng thái trước)

        // // ── Undo GarageDoor ───────────────────────────────────────────────────
        // System.out.println("\n=== Garage Door ===");
        // remote.onPressButton(2);          // Garage UP
        // remote.undoPressButton();         // → Garage DOWN

        // // ── Undo Stereo ───────────────────────────────────────────────────────
        // System.out.println("\n=== Stereo ===");
        // remote.onPressButton(3);          // Stereo ON + CD
        // remote.undoPressButton();         // → Stereo OFF
        // remote.offPressButton(3);         // Stereo OFF
        // remote.undoPressButton();         // → Stereo ON + CD lại

        CeilingFan ceilingFan = new CeilingFan("Living Room");
        CeilingFanMediumCommand ceilingFanMedium =
        new CeilingFanMediumCommand(ceilingFan);
        CeilingFanHighCommand ceilingFanHigh =
        new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff =
        new CeilingFanOffCommand(ceilingFan);
        remote.setCommand(0, ceilingFanMedium, ceilingFanOff);
        remote.setCommand(1, ceilingFanHigh, ceilingFanOff);
        remote.onPressButton(0);
        remote.offPressButton(0);
        remote.onPressButton(1);
        remote.offPressButton(1);
        remote.undoPressButton();
        // ── MacroCommand: Party Mode ──────────────────────────────────────────
        System.out.println("\n========== MacroCommand Test ==========");
        System.out.println("--- [Party ON] bật hết một lần ---");

        // gom các lệnh ON vào một macro
        Command[] partyOn  = { lightOn, fanOn, stereoOn };
        Command[] partyOff = { lightOff, fanOff, stereoOff };

        MacroCommand partyOnMacro  = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remote.setCommand(4, partyOnMacro, partyOffMacro);

        remote.onPressButton(4);    // bật đồng loạt: light + fan + stereo
        System.out.println("\n--- [UNDO Party ON] tắt hết ---");
        remote.undoPressButton();   // undo đồng loạt

        System.out.println("\n--- [Party OFF] tắt hết một lần ---");
        remote.offPressButton(4);
        System.out.println("\n--- [UNDO Party OFF] bật lại hết ---");
        remote.undoPressButton();
    }
}
