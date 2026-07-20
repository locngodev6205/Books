package com.hfdp.duck.behavior.quack;

/** Vịt mồi nhử – im lặng hoàn toàn. */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
