package com.kyxw008.rpcorder;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by kyxw007 on 15/4/4.
 */
public class ClientRemote {
    public static void main(String args[]) {
        String host = "127.0.0.1";
        LocalInterface localinterface = null;
        try {
            localinterface = (LocalInterface) Naming.lookup("rmi://" + host + "/remote.LocalInterface");
            int[] a = {1,2,5,8,10,4,3,6,9,7};
            localinterface.resetHandler();
            for (int i:a){
                localinterface.requestRPC(i);
            }

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
