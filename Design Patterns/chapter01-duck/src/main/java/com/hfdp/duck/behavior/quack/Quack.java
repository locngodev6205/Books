package com.hfdp.duck.behavior.quack;

/** Tiếng kêu thật của vịt. */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
