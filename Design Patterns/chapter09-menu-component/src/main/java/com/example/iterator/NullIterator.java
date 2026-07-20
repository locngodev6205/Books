package com.example.iterator;

import java.util.Iterator;

import com.example.component.MenuComponent;

public class NullIterator implements Iterator<MenuComponent> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }
    
}
