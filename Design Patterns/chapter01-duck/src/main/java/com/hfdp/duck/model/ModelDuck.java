package com.hfdp.duck.model;

import com.hfdp.duck.behavior.fly.FlyNoWay;
import com.hfdp.duck.behavior.quack.Quack;

/**
 * ModelDuck ban đầu không bay được.
 * Dùng để minh họa đổi chiến lược lúc runtime qua setFlyBehavior().
 */
public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior   = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
