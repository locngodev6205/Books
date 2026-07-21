package com.example.state;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.example.remote.GumballMachineRemote;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    String location;
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;
    public GumballMachine(String location, int numberGumballs) throws RemoteException {
        this.location = location;
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        winnerState = new WinnerState(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }
    // state handle
    public void insertQuarter() {
        state.insertQuarter();
    }
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }
    
    // getter
    public int getCount() {
        return count;
    }
    public String getLocation() {
        return location;
    }
    public State getHasQuarterState() {
        return hasQuarterState;
    }
    public State getNoQuarterState() {
        return noQuarterState;
    }
    public State getSoldOutState() {
        return soldOutState;
    }
    public State getSoldState() {
        return soldState;
    }
    public State getWinnerState() {
        return winnerState;
    }
    public State getState() {
        return state;
    }

    public void refill(int number) {
        this.count += number;
        if (this.count > 0) {
            System.out.println("You just refill " + number + " gumball");
            this.state = noQuarterState;
        }
        else this.state = soldOutState;
    }
    @Override
    public String toString() {
        return "GumballMachine [state=" + state + ", count=" + count + "]";
    }
}