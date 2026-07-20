package com.example.starbuzz;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        switch (getSize()) {
            case TALL   -> cost += .10;
            case GRANDE -> cost += .15;
            case VENTI  -> cost += .20;
        }
        return cost;
    }
}
