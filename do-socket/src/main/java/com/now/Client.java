package com.now;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 */
public class Client {
    /**
     * InetAddress详解
     * InetAddress类表示服务器的IP地址，InetAddress类来提供了一系列静态工厂方法，用于构造自身的实例，例如：
     * InetAddress addr1 = InetAddress.getLocalHost();  //返回本地主机的IP地址。
     * InetAddress addr2 = InetAddress.getByName("222.18.19.8");  //返回代表222.18.19.8的IP地址。
     * InetAddress addr2 = InetAddress.getByName("www.now.com");  //返回域名为www.now.com的IP地址。
     */
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 8888;
        System.out.println("连接到主机："+serverName+"("+port+")");
        try {
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址："+ client.getRemoteSocketAddress());

            //获取输出流输出信息
            OutputStream out = client.getOutputStream();
            DataOutputStream dataOut = new DataOutputStream(out);
            dataOut.writeUTF("你好！");

            //获取输入流读取服务器返回的信息
            InputStream in = client.getInputStream();
            DataInputStream dataInput = new DataInputStream(in);
            System.out.println("服务器响应："+dataInput.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
