package com.example.starbuzz;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        // Soy tính theo size: 10¢ / 15¢ / 20¢
        switch (getSize()) {
            case TALL   -> cost += .10;
            case GRANDE -> cost += .15;
            case VENTI  -> cost += .20;
        }
        return cost;
    }
}
