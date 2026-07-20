package com.hfdp.duck.behavior.fly;

/**
 * Strategy interface – hành vi bay.
 * Tách hành vi ra khỏi Duck để thay đổi linh hoạt lúc runtime.
 */
public interface FlyBehavior {
    void fly();
}
