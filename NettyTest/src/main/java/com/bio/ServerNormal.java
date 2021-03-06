package com.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNormal {
    //默认端口号
    private static int DEFAULT_PORT=12345;

    //单例的ServerSocket
    private static ServerSocket server;

    //根据传入参数设置监听端口，如果没有参数调用以下方法并使用默认值
    public static void start() throws IOException {
        //使用默认值
        start(DEFAULT_PORT);
    }

    //这个方法不会被大量并发访问，不太需要考虑效率，直接进行方法同步就行了
    public synchronized static void start(int port) throws IOException {
        //这个写法啥意思*********
        if(server != null) return ;
        //通过构造函数创建ServerSocket
        //如果端口合法且空闲，服务端就监听成功
       try {
           server = new ServerSocket(port);
           System.out.println("服务器已启动，端口号：" + port);

           //通过无线循环监听客户端连接
           //如果没有客户端接入，将阻塞在accept操作上
           while (true) {
               //接收客户端连接，等待连接
               Socket socket = server.accept();
               //当有新的客户端接入，执行以下代码
               //然后创建一个新的线程来处理这条socket来链路
               new Thread(new ServerHanler(socket)).start();
           }
       }finally {
           if(server != null){
               System.out.println("服务器已关闭。");
               server.close();
               server = null;
           }
       }
    }
}
