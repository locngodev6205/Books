package com.example.ingredient;

import com.example.ingredient.cheese.Cheese;
import com.example.ingredient.cheese.ReggianoCheese;
import com.example.ingredient.clams.Clams;
import com.example.ingredient.clams.FreshClams;
import com.example.ingredient.dough.Dough;
import com.example.ingredient.dough.ThinCrustDough;
import com.example.ingredient.pepperoni.Pepperoni;
import com.example.ingredient.pepperoni.SlicedPepperoni;
import com.example.ingredient.sauce.MarinaraSauce;
import com.example.ingredient.sauce.Sauce;
import com.example.ingredient.veggies.Garlic;
import com.example.ingredient.veggies.Mushroom;
import com.example.ingredient.veggies.Onion;
import com.example.ingredient.veggies.RedPepper;
import com.example.ingredient.veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
    
}
