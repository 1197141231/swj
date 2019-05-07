package com.bugong.event;

// java.util.EventObject是事件状态对象的基类，它封装了事件源对象以及和事件相关的信息。所有java的事件类都需要继承该类。

import java.util.EventObject;

//事件对象
public class FileEvent extends EventObject {

    private static final long serialVersionUID = 1L;
    private String fileState;//上传状态 和  下载状态

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */

    public FileEvent(Object source, String fileState) {
        super(source);
        this.fileState = fileState;
    }

    public String getFileState() {
        return fileState;
    }
}

