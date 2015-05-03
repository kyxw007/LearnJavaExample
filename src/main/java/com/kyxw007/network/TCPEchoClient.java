package com.kyxw007.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.IllegalFormatException;

/**
 * Created by kyxw007 on 15/3/16.
 */
public class TCPEchoClient {
    public static void main(String[] args) throws IOException{
        if(args.length<2||args.length>3){
            throw new IllegalArgumentException("参数：<Server><Word>[<Port>]");
        }
        String server = args[0];
        byte[] data = "heiheia".getBytes();
        int servPort = (args.length ==3)?Integer.parseInt(args[2]):7;
        Socket socket = new Socket(server,servPort);
        System.out.println("Connected to server ...  sending echo string ");
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        out.write(data);
        int totalBytesRcvd = 0;
        int byteRcvd;
        while (totalBytesRcvd <data.length){
            if((byteRcvd = in.read(data,totalBytesRcvd,data.length-totalBytesRcvd))==-1){
                throw new SocketException("Connection closed prematurely");

            }
            totalBytesRcvd += byteRcvd;
        }

        System.out.println("Received:"+new String(data));

        socket.close();


    }
}
