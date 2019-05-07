package com.bugong.thread;

public class AFileThread implements Runnable {
    private String name;
    private Thread t;

    public AFileThread(String name) {
        this.name = name;
    }


    //线程运行
    public void run() {
        for (int i = 1; i < 4; i++) {
            System.out.println("文件A" + "第" + i + "次" + name + "中。。。。。");

            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //线程就绪
    public void start() {
        System.out.println("Starting " + name);
        if (t == null) {
            t = new Thread(this, name);
            t.start();
        }
    }
}