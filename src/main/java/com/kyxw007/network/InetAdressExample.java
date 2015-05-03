package com.kyxw007.network;

import java.net.*;
import java.util.Enumeration;

/**
 * Created by kyxw007 on 15/3/16.
 */
public class InetAdressExample {
    public static void main(String[] args){
        try{
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
            if(interfaceList==null){
                System.out.println("-- no interfaces found --");
            }else {
                while (interfaceList.hasMoreElements()){
                    NetworkInterface iface = interfaceList.nextElement();
                    System.out.println("Interface:"+iface.getName()+":");
                    Enumeration<InetAddress> addrList = iface.getInetAddresses();
                    if(!addrList.hasMoreElements()){
                        System.out.println("\t No address for this interface ");
                    }
                    while (addrList.hasMoreElements()){
                        InetAddress addr = addrList.nextElement();
                        System.out.println("\t Address "+((addr instanceof Inet4Address)?"(v4)":((addr instanceof Inet6Address)?"(v6)":"(?)"))+":"+addr.getHostAddress());
                    }
                }
            }
        }catch (SocketException se){
            System.out.println(se);
        }

        for (String host:args){
            System.out.println(host+":");
            try {
                InetAddress[] addressList = InetAddress.getAllByName(host);
                for (InetAddress address:addressList){
                    System.out.println("\t"+address.getHostName()+"/"+address.getHostAddress());
                }
            } catch (UnknownHostException e) {
                System.out.println("\tUnable to find address for " + host);
            }
        }
    }
}
