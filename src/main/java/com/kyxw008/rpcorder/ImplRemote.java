package com.kyxw008.rpcorder;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by kyxw007 on 15/4/4.
 */
public class ImplRemote extends UnicastRemoteObject implements LocalInterface {
    private RemoteHandler rh = new RemoteHandler();

    /**
     * 构造函数，初始化远程调用注册，并绑定调用类
     * @throws RemoteException
     */
    protected ImplRemote() throws RemoteException {
        super();
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("Create Registry");
            Naming.rebind("//localhost/RMIServerClass", this);
            System.out.println("RMIServer bound in registry");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    /**
     *  远程调用接口实现
     * @param i
     * @throws RemoteException
     */
    @Override
    public void requestRPC(int i) throws RemoteException {
        //System.out.println("这是一个远程调用："+i);
        rh.handle(i);
    }

    @Override
    public void resetHandler() throws RemoteException {
        rh.reset();
    }

}
