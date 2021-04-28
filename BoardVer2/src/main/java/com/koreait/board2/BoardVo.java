package com.koreait.board2;

public class BoardVo {
	//데이터베이스에서 테이블의 한 레코드가 이 클래스의 객체가 된다.
	//멤버변수는 그 테이블의 컬럼들
	private String title;
	private String ctnt;
	
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
}
