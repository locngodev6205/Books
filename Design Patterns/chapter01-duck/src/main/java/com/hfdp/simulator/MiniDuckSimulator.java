package com.hfdp.simulator;

import com.hfdp.duck.behavior.fly.FlyRocketPowered;
import com.hfdp.duck.model.DecoyDuck;
import com.hfdp.duck.model.Duck;
import com.hfdp.duck.model.MallardDuck;
import com.hfdp.duck.model.ModelDuck;
import com.hfdp.duck.model.RubberDuck;

/**
 * MiniDuckSimulator – entry point.
 *
 * <p>Minh họa hai điểm mấu chốt của Strategy Pattern:
 * <ol>
 *   <li>Mỗi loại vịt dùng chiến lược riêng được inject qua constructor.</li>
 *   <li>Chiến lược có thể thay bằng {@code setFlyBehavior()} <b>lúc runtime</b>.</li>
 * </ol>
 */
public class MiniDuckSimulator {

    public static void main(String[] args) {

        // ── 1. Vịt trời ─────────────────────────────────────────────────────
        System.out.println("=== MallardDuck ===");
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();
        mallard.swim();

        System.out.println();

        // ── 2. Vịt cao su ───────────────────────────────────────────────────
        System.out.println("=== RubberDuck ===");
        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.performFly();
        rubber.performQuack();

        System.out.println();

        // ── 3. Vịt mồi nhử ──────────────────────────────────────────────────
        System.out.println("=== DecoyDuck ===");
        Duck decoy = new DecoyDuck();
        decoy.display();
        decoy.performFly();
        decoy.performQuack();

        System.out.println();

        // ── 4. Đổi chiến lược lúc RUNTIME ───────────────────────────────────
        System.out.println("=== ModelDuck (runtime behavior change) ===");
        Duck model = new ModelDuck();
        model.display();
        model.performFly();                              // FlyNoWay

        System.out.println("-- Gắn tên lửa vào ModelDuck --");
        model.setFlyBehavior(new FlyRocketPowered());   // thay chiến lược!
        model.performFly();                              // FlyRocketPowered
    }
}
