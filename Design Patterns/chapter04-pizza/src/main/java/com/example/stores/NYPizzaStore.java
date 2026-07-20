package com.example.stores;

import com.example.ingredient.NYPizzaIngredientFactory;
import com.example.ingredient.PizzaIngredientFactory;
import com.example.pizzas.CheesePizza;
import com.example.pizzas.ClamPizza;
import com.example.pizzas.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        }
        return pizza;
    }
}
