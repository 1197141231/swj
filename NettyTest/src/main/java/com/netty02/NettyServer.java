package com.netty02;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class NettyServer {

    /*
    要启动一个Netty服务端，必须要指定三类属性，分别是1.线程模型、2.IO模型、3.连接读写处理逻辑，
    有了这三者，之后在调用bind(8000)，我们就可以在本地绑定一个8000端口启动起来
    */
    public static void main(String[] args) {
       //引导类，进行服务端的启动，设置服务的帮助类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
       //监听端口，接收新连接线程
        NioEventLoopGroup boos = new NioEventLoopGroup();
       //读取每条连接的数据的线程
        NioEventLoopGroup worker = new NioEventLoopGroup();

    //  bind(serverBootstrap,1000);还需再修改bind方法实现
        serverBootstrap
                //1.配置两个线程，引导类模型定型
                .group(boos,worker)
                //2.指定io模型为NIO  bio模型为OioServerSocketChannel.class，一般不用，netty优势在于NIO
                .channel(NioServerSocketChannel.class)
                //3.定义后续每条连接的数据读写，业务处理逻辑
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                }).bind(8000).addListener(new GenericFutureListener<Future<? super Void>>() {
                             public void operationComplete(Future<? super Void> future) {
                                    if (future.isSuccess()) {
                                        System.out.println("端口绑定成功!");
                                    } else {
                                        System.err.println("端口绑定失败!");
                                    }
                             }
                    });

    }




    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            public void operationComplete(Future<? super Void> future) {
                if (future.isSuccess()) {
                    System.out.println("端口[" + port + "]绑定成功!");
                } else {
                    System.err.println("端口[" + port + "]绑定失败!");
                    bind(serverBootstrap, port + 1);
                }
            }
        });
    }






}