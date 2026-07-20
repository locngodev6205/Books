package com.hfdp.duck.model;

import com.hfdp.duck.behavior.fly.FlyNoWay;
import com.hfdp.duck.behavior.quack.Squeak;

/** Vịt cao su – không bay được, kêu kẹt. */
public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior   = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("I'm a rubber duckie");
    }
}
