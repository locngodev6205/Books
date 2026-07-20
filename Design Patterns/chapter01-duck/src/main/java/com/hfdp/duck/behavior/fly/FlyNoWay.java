package com.hfdp.duck.behavior.fly;

/** Vịt không biết bay (vịt cao su, mồi nhử…). */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly.");
    }
}
