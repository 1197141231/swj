package com.bugong.serializable;

import java.io.Serializable;


//定义file类  序列化Serializable接口
public class AFile implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    private String realName; //文件名
    private String fileSize; //文件大小


    public AFile(String realName, String fileSize) {
        this.realName = realName;
        this.fileSize = fileSize;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        realName = realName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "AFile{" +
                "realName='" + realName + '\'' +
                ", fileSize='" + fileSize + '\'' +
                '}';
    }

}
