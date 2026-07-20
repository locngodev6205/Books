package com.example.ingredient;

import com.example.ingredient.cheese.Cheese;
import com.example.ingredient.clams.Clams;
import com.example.ingredient.dough.Dough;
import com.example.ingredient.pepperoni.Pepperoni;
import com.example.ingredient.sauce.Sauce;
import com.example.ingredient.veggies.Veggies;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClams();
}