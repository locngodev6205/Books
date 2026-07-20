package com.hfdp.duck.model;

import com.hfdp.duck.behavior.fly.FlyNoWay;
import com.hfdp.duck.behavior.quack.MuteQuack;

/** Vịt mồi nhử – không bay, không kêu. */
public class DecoyDuck extends Duck {

    public DecoyDuck() {
        flyBehavior   = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a decoy duck");
    }
}
