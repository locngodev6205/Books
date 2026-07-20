package com.hfdp.duck.model;

import com.hfdp.duck.behavior.fly.FlyWithWings;
import com.hfdp.duck.behavior.quack.Quack;

/** Vịt trời bình thường – bay được, kêu thật. */
public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior   = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
