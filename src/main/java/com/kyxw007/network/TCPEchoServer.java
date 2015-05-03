package com.kyxw007.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by kyxw007 on 15/3/16.
 */
public class TCPEchoServer {
    private static final int BUFSIZE =32;
    public static void main(String[] args) throws IOException {
        int serverPort = 7707;
        ServerSocket servSock = new ServerSocket(serverPort);
        int recvMsgSize;
        byte[] receiveBuf = new byte[BUFSIZE];
        while (true){
            Socket clntSock = servSock.accept();
            SocketAddress clientAddress=clntSock.getRemoteSocketAddress();
            System.out.println("Handling Client :" + clientAddress);
            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();

            while((recvMsgSize = in.read(receiveBuf))!=-1){
                out.write(receiveBuf,0,recvMsgSize);
            }
            clntSock.close();

        }
    }
}
