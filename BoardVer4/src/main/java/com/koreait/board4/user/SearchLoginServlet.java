package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/user/searchLogin")
public class SearchLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/searchLogin", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String user_Name = request.getParameter("user_Name");
		String gender = request.getParameter("gender");
		String user_Email = request.getParameter("user_Email");
		String user_Id = request.getParameter("user_Id");
		
		//hisVo에 넣기
		
		if (search.equals("id")) {
			//hisVo 검사 - id용 - boolean 
			//true이면 MailSendID 그리고 return
			//false이면 alert (일치하는 정보가 없습니다. 다시 확인해보세요.)
			//5번 틀리면 회원가입으로 이동 //일치하는 정보가 없습니다. 아무래도 회원가입 해야겠죠?
		}
		
		if (search.equals("pw")) {
			//hisVo 검사 - id용
			//true이면 MailSendPW 그리고 return
			//false이면 alert (일치하는 정보가 없습니다. 다시 확인해보세요.)
			//5번 틀리면 회원가입으로 이동 //일치하는 정보가 없습니다. 아무래도 회원가입 해야겠죠?
		}
		
	}
}
