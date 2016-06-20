package com.shopsyetem;

import java.util.Scanner;

import com.shopsyetem.entity.LogIn;
import com.shopsyetem.entity.Register;

public class Shopping {

	public static void main(String[] args) {
		System.out.println("欢迎进入瑞才商品管理系统");
		System.out.println("**************************");
		System.out.println("1.登陆     2.注册       3.退出");
		Scanner num = new Scanner(System.in);
		LogIn log =new LogIn();
		Register reg = new Register();
		int n = num.nextInt();
	    switch (n) {
		case 1:
			log.shopLogIn();
			break;
		case 2:
			reg.shopRegister();
		case 3:
			System.exit(n);
		default:
			System.out.println("输入错误");
			break;
		}		
	}
}
