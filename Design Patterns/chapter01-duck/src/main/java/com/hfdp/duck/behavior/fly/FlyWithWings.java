package com.hfdp.duck.behavior.fly;

/** Vịt thật – bay bằng cánh. */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!!");
    }
}
