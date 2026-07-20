package com.hfdp.duck.behavior.fly;

/** Bay bằng tên lửa – có thể gán lúc runtime. */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
