package com.bugong.event;

import com.bugong.impl.FileListener;
import com.bugong.thread.AFileThread;

public class FileListener2 implements FileListener {





    @Override
    public void fileEvent(FileEvent event) {
        if (event.getFileState() != null && event.getFileState().equals("upload")) {
            System.out.println("文件B上传，同时备份...");
            new AFileThread("upload").run();
            System.out.println("文件B上传完毕");
            System.out.println("*************");
        } else {
            System.out.println("文件B下载，同时备份...");
        }
    }
}
