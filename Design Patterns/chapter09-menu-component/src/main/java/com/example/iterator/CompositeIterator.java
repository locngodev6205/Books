package com.example.iterator;

import java.util.Iterator;
import java.util.Stack;

import com.example.component.MenuComponent;
import com.example.menu.Menu;

public class CompositeIterator implements Iterator<MenuComponent> {
    Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        
        Iterator<MenuComponent> iterator = stack.peek();
        if (!iterator.hasNext()) {
            stack.pop();
            return hasNext();
        }
        return true;
    }

    @Override
    public MenuComponent next() {
        if (!hasNext()) return null;

        Iterator<MenuComponent> iterator = stack.peek();
        MenuComponent menuComponent = iterator.next();
        if (menuComponent instanceof Menu) {
            stack.push(menuComponent.createIterator());
        }
        return menuComponent;
    }   
    
}
