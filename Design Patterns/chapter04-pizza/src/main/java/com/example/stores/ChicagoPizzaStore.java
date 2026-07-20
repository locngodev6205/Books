package com.example.stores;

import com.example.ingredient.ChicagoPizzaIngredientFactory;
import com.example.ingredient.PizzaIngredientFactory;
import com.example.pizzas.CheesePizza;
import com.example.pizzas.ClamPizza;
import com.example.pizzas.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Deep Dish Cheese Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        }
        return pizza;
    }
}
