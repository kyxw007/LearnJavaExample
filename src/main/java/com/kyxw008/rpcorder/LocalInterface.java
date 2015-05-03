package com.kyxw008.rpcorder;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by kyxw007 on 15/4/4.
 */
public interface LocalInterface extends Remote {
    public void requestRPC(int i) throws RemoteException;
    public void resetHandler() throws  RemoteException;
}
