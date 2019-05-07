package com.bugong;


import com.bugong.event.FileListener1;
import com.bugong.event.FileListener2;
import com.bugong.event.FileSourse;
import com.bugong.serializable.AFile;
import com.bugong.serializable.FileSerializable;

public class FileTest {

    public static void main(String[] args) throws Exception {

        FileSerializable fileSerializable = new FileSerializable();

        //事件监听
        FileSourse fs = new FileSourse();

        fs.addFileListener(new FileListener2());// 给文件B增加监听器
        fs.addFileListener(new FileListener1());// 给文件A增加监听器



        // 上传
        fs.fileUpload();
        System.out.println("******");

        // 序列化AFile对象
        AFile afile = new AFile("filaA", "1024kb");
        System.out.println(afile+"!!!");

        String str = fileSerializable.SerializeFile(afile);
        System.out.println(str+ "@@@");



        // 下载
        fs.fileDownload();

        // 反序列AFile对象

        AFile file = fileSerializable.DeserializeFile(str);
        System.out.println(file+"###");

        //通过反射机制 以对象获得包名
        System.out.println(file.getClass().getName());
    }


}
