package com.bugong.serializable;

import com.bugong.serializable.AFile;

import java.io.*;

//file信息序列化 及 反序列化
public class FileSerializable {


    //序列化文件
    public static String SerializeFile(AFile file) throws FileNotFoundException,
            IOException {

        //此方法为保存为string字符串
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        objOut.writeObject(file);
        String str = byteOut.toString("ISO-8859-1");

        //此方法为将对象保存为文本形式
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Afile.txt")));
        oo.writeObject(file);
        oo.close();

        //验证

        System.out.println("文件a序列化成功");

        return str;
    }


    //反序列化文件
    public static AFile DeserializeFile(String str) throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("E:/Afile.txt")));
        AFile file = (AFile) ois.readObject();
        System.out.println("文件a反序列化成功！");


        ByteArrayInputStream byteIn = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
        ObjectInputStream objIn = new ObjectInputStream(byteIn);
        Object obj =objIn.readObject();


        return file;
    }

}


//反序列化文件
   /* private static AFile DeserializeFile{

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(
                                  new File("E:/Afile.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        AFile file = null;
        try {
            file = (AFile) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Customer对象反序列化成功！");
              return file;


    }*/