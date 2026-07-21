package com.example.monitor;

import java.rmi.RemoteException;

import com.example.remote.GumballMachineRemote;

/**
 * Monitor theo dõi trạng thái GumballMachine từ xa qua RMI.
 */
public class GumballMonitor {
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote gumballMachine) {
        this.machine = gumballMachine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + machine.getLocation());
            System.out.println("Current inventory: " + machine.getCount() + " gumballs");
            System.out.println("Current state: " + machine.getState());
        } catch (RemoteException e) {
            System.err.println("Lỗi kết nối từ xa: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
