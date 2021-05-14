package com.koreait.board4.user;

public class UserVo {
	private int iUser;
	private String user_Id;
	private String user_Pw;
	private String user_Name;
	private int gender;
	private String regdt;
	private String user_Email;
	private int listCount;
	private int delCount;
	private int modCount;
	
	@Override
	public String toString() {
		return String.format("iUser %s | user_Id %s | user_Pw %s | user_Name %s | gender %s | regdt %s | user_Email %s | listCount %d | delCount %d | modCount %d\n", iUser, user_Id, user_Pw, user_Name, (gender==0?"남":"여"), regdt, user_Email, listCount, delCount, modCount);
	}

	public int getiUser() {
		return iUser;
	}
	public void setiUser(int iUser) {
		this.iUser = iUser;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Pw() {
		return user_Pw;
	}
	public void setUser_Pw(String user_Pw) {
		this.user_Pw = user_Pw;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	public String getUser_Email() {
		return user_Email;
	}

	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getDelCount() {
		return delCount;
	}

	public void setDelCount(int delCount) {
		this.delCount = delCount;
	}

	public int getModCount() {
		return modCount;
	}

	public void setModCount(int modCount) {
		this.modCount = modCount;
	}
}
