package com.example;

import com.example.state.GumballMachine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        gumballMachine.refill(5);
        System.out.println(gumballMachine);
    }
}
