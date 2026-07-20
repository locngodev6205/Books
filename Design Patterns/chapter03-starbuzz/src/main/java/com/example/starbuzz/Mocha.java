package com.example.starbuzz;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
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
