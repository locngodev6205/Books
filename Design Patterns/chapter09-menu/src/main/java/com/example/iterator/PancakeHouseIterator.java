package com.example.iterator;

import java.util.ArrayList;

import com.example.menu.MenuItem;

public class PancakeHouseIterator implements Iterator {
    ArrayList<MenuItem> items;
    int position = 0;

    public PancakeHouseIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Object next() {
        MenuItem menuItem = items.get(position);
        position += 1;
        return menuItem;
    }
    
}
