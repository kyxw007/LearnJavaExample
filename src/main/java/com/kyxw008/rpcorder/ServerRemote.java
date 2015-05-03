package com.kyxw008.rpcorder;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by kyxw007 on 15/4/4.
 */
public class ServerRemote {
    public static void main(String[] args){
        try{
            ImplRemote local=new ImplRemote();//生成远程对象的一个实例
            Naming.rebind("rmi:///remote.LocalInterface", local);//将远程对象实例绑定到LocalInterface

        }catch(RemoteException e){
            System.out.println("RemoteException"+e);
        }
        catch(MalformedURLException mfe){
            System.out.println("MalformedURLException:"+mfe);
        }
    }
}
