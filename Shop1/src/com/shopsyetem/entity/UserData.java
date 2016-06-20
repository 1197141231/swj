package com.shopsyetem.entity;

public class UserData {
		String userName;
		int passWork;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public int getPassWork() {
			return passWork;
		}
		public void setPassWork(int passWork) {
			this.passWork = passWork;
		}
		public UserData(String userName, int passWork) {
			super();
			this.userName = userName;
			this.passWork = passWork;
		}
		@Override
		public String toString() {
			return "UserData [userName=" + userName + ", passWork=" + passWork + "]";
		}
		
}
