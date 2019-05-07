package com.bugong.event;

import com.bugong.impl.FileListener;
import com.bugong.thread.AFileThread;

public class FileListener1  implements FileListener {


    @Override
    public void fileEvent(FileEvent event) {
        if (event.getFileState() != null && event.getFileState().equals("upload")) {
            System.out.println("文件A上传");
            new AFileThread("upload块1").start();
            new AFileThread("upload块2").start();
            new AFileThread("upload块3").start();

        } else {
            System.out.println("文件A下载");
        }

    }
}
