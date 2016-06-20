package com.shopsyetem.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogIn {
		public static List<UserData> users= new ArrayList<UserData>();
		Scanner in = new Scanner(System.in);
		public void shopLogIn() {
		System.out.println("请输入注册用户名");
		String userName = in.next();
		System.out.println("请输入注册用户密码");
		int passWork = in.nextInt();
		UserData user = new UserData(userName, passWork);
		if (users.size()==0) {
			
		} else {

		}
		
	}
}
