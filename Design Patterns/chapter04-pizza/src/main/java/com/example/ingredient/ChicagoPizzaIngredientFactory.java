package com.example.ingredient;

import com.example.ingredient.cheese.Cheese;
import com.example.ingredient.cheese.MozzarellaCheese;
import com.example.ingredient.clams.Clams;
import com.example.ingredient.clams.FrozenClams;
import com.example.ingredient.dough.Dough;
import com.example.ingredient.dough.ThickCrustDough;
import com.example.ingredient.pepperoni.Pepperoni;
import com.example.ingredient.pepperoni.SlicedPepperoni;
import com.example.ingredient.sauce.PlumTomatoSauce;
import com.example.ingredient.sauce.Sauce;
import com.example.ingredient.veggies.BlackOlives;
import com.example.ingredient.veggies.EggPlant;
import com.example.ingredient.veggies.Spinach;
import com.example.ingredient.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{ new BlackOlives(), new Spinach(), new EggPlant() };
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
