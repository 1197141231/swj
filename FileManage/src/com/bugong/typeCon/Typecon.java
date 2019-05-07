package com.bugong.typeCon;

public class Typecon {


    public static void main(String[] args){

        //Int型数字转换成String
        int num1=123456;
        //方法1
        String str1=num1+"";
        System.out.println(str1);
        //方法2
        String str2=String.valueOf(num1);
        System.out.println(str2);

        //String转换成Int型数字
        String str3=new String("9876543");
        int num2=Integer.parseInt(str3);
        System.out.println(num1+num2);

        //字符转换成字符型数组
        String str4="HRuinger";
        char a[]=str4.toCharArray();
        for(int i:a)
            System.out.print((char)i+" ");
        System.out.println();

        //字符型数组转换成字符串
        char b[]={'H','R','u','i','n','g'};
        String str5=String.valueOf(b);
        System.out.println(str5);

        //整型与字符型数值的转换
        char c='3';
        System.out.println(c-'0');     //此处也可以为c-48
        int d=5;
        System.out.println((char)(d+'0'));    //此处也可以为c+48



    }

}
