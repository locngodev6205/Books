package com.example.pizzas;

import com.example.ingredient.cheese.Cheese;
import com.example.ingredient.clams.Clams;
import com.example.ingredient.dough.Dough;
import com.example.ingredient.pepperoni.Pepperoni;
import com.example.ingredient.sauce.Sauce;
import com.example.ingredient.veggies.Veggies;

public abstract class Pizza {

    String name;
    Dough      dough;
    Sauce      sauce;
    Veggies[]  veggies;
    Cheese     cheese;
    Pepperoni  pepperoni;
    Clams      clam;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() { return name; }
    public void   setName(String name) { this.name = name; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---- ").append(name).append(" ----\n");
        if (dough     != null) sb.append(dough).append("\n");
        if (sauce     != null) sb.append(sauce).append("\n");
        if (cheese    != null) sb.append(cheese).append("\n");
        if (veggies   != null) {
            for (Veggies v : veggies) sb.append(v).append("\n");
        }
        if (clam      != null) sb.append(clam).append("\n");
        if (pepperoni != null) sb.append(pepperoni).append("\n");
        return sb.toString();
    }
}
