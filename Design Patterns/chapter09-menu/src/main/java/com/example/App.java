package com.example;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.menu.CafeMenu;
import com.example.menu.DinerMenu;
import com.example.menu.Menu;
import com.example.menu.PancakeHouseMenu;
import com.example.waitress.Waitress;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();
        Waitress waitress = new Waitress(new ArrayList<Menu>(Arrays.asList(pancakeHouseMenu, dinerMenu, cafeMenu)));
        waitress.printMenu();
    }
}
