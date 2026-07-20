package com.hfdp.duck.behavior.quack;

/** Vịt cao su – kêu kẹt kẹt. */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak!");
    }
}
