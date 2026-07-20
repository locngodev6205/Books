package com.hfdp.duck.model;

import com.hfdp.duck.behavior.fly.FlyBehavior;
import com.hfdp.duck.behavior.quack.QuackBehavior;

/**
 * Context – lớp trừu tượng Duck.
 *
 * <p>Duck <b>HAS-A</b> FlyBehavior và QuackBehavior (composition).
 * Hành vi có thể thay đổi lúc runtime qua các setter.
 *
 * <p><b>Design principle:</b>
 * <em>"Favour composition over inheritance."</em>
 */
public abstract class Duck {

    // HAS-A (composition) – không phải IS-A (inheritance)
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    /** Mỗi loại vịt tự hiển thị ngoại hình của mình. */
    public abstract void display();

    /** Ủy quyền (delegate) cho chiến lược fly hiện tại. */
    public void performFly() {
        flyBehavior.fly();
    }

    /** Ủy quyền (delegate) cho chiến lược quack hiện tại. */
    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("All ducks float, even decoy ducks!");
    }

    // ── Setters – đổi chiến lược lúc runtime ─────────────────────────────────

    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }
}
