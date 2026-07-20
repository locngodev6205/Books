package com.example.waitress;

import java.util.ArrayList;
import java.util.Iterator;
import com.example.menu.Menu;
import com.example.menu.MenuItem;

public class Waitress {
    ArrayList<Menu> menus;
    public Waitress(ArrayList<Menu> menus) {
        this.menus = menus;
    }
    public void printMenu() {
        Iterator<Menu> menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            System.out.println("\nNext Menu:");
            printMenu(menu.createIterator()); 
        }
    }
    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
    // other methods here
}