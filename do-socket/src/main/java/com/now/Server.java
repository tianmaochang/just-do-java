package com.now;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 */
public class Server extends Thread{
    private ServerSocket serverSocket;
    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
//        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        while (true){
            System.out.println("等待客户端连接...");

            try {
                Socket server = serverSocket.accept();
                System.out.println("客户端（"+server.getRemoteSocketAddress()+"）已连接");

                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(server.getRemoteSocketAddress()+"："+in.readUTF());

                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("谢谢！");
            } catch (IOException e) {
                System.out.println("Socket time out!");
//                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = 8888;
        try {
            Thread thread = new Server(port);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
