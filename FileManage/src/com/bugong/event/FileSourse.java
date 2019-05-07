package com.bugong.event;


import com.bugong.impl.FileListener;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

//事件源
public class FileSourse {
    private Collection listeners;

    /**
     * 添加事件
     * 存储方式
     * @param listener
     *            DoorListener
     */
    public void addFileListener(FileListener listener) {
        if (listeners == null) {
            listeners = new HashSet();
        }
        listeners.add(listener);
    }

    /**
     * 移除事件
     * 存储方式
     * @param listener
     *            DoorListener
     */
    public void removeFileListener(FileListener listener) {
        if (listeners == null)
            return;
        listeners.remove(listener);
    }

    /**
     * 触发上传事件
     * 触发事件
     */
    public void fileUpload() {
        if (listeners == null)
            return;
        FileEvent event = new FileEvent(this, "upload");
        notifyListeners(event);
    }

    /**
     * 触发下载事件
     * 触发事件
     */
    public void fileDownload() {
        if (listeners == null)
            return;
        FileEvent event = new FileEvent(this, "download");
        notifyListeners(event);
    }

    /**
     *
     * 触发事件发生后 通知所有的FileListener做相应操作
     */
    private void notifyListeners(FileEvent event) {
        Iterator iter = listeners.iterator();
        while (iter.hasNext()) {
            FileListener listener = (FileListener) iter.next();
            listener.fileEvent(event);
        }
    }



}
