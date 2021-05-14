package com.koreait.board4.board;

public class BoardVo {
	private int iboard;
	private String title;
	private String ctnt;
	private int iuser;
	private String regdt;
	
	private String user_Name;
	private String user_Id;
	
	@Override
	public String toString() {
		return String.format("iboard %d | title %s | ctnt %s | iuser %d | regdt %s | user_Name %s | user_Id %s\n", iboard, title, ctnt, iuser, regdt, user_Name, user_Id);
	}

	public int getIboard() {
		return iboard;
	}

	public void setIboard(int iboard) {
		this.iboard = iboard;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCtnt() {
		return ctnt;
	}

	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}

	public int getIuser() {
		return iuser;
	}

	public void setIuser(int iuser) {
		this.iuser = iuser;
	}

	public String getRegdt() {
		return regdt;
	}

	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
}
