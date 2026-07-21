package com.example.remote;

import java.rmi.*;

import com.example.state.State;

// Interface mô tả một đối tượng có thể được gọi từ xa thông qua RMI.
public interface GumballMachineRemote extends Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}
