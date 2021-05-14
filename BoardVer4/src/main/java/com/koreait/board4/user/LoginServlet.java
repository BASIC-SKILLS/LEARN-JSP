package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getLoginUser(request);
		
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}
		
		MyUtils.openJSP("user/login", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String user_Id = request.getParameter("user_Id");
		String user_Pw = request.getParameter("user_Pw");
		
		UserVo vo = new UserVo();
		vo.setUser_Id(user_Id);
		vo.setUser_Pw(user_Pw);
		
		int checkLogin = UserDao.checkLogin(vo);
		if(checkLogin == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			response.sendRedirect("/board/list");
			return;
		}
		
		int err = MyUtils.getIntParam("err", request);
		int errId = MyUtils.getIntParam("errId", request);
		int errPw = MyUtils.getIntParam("errPw", request);
		String errMsg = "";
		switch(checkLogin) {
		case 0 : 
			err++;
			errMsg = "error"; 
			moveSearchLogin(err, errMsg, request, response);
			break;
		case 2 : 
			errId++;
			errMsg = "id"; 
			moveSearchLogin(errId, errMsg, request, response);
			break;
		case 3 : 
			errPw++; 
			errMsg = "pw"; 
			moveSearchLogin(errPw, errMsg, request, response);
			break;
		}
		
		if (err>5 || errId>5 || errPw>5) return;
		response.sendRedirect("login?err="+err+"&errId="+errId+"&errPw="+errPw+"&errMsg="+errMsg);
	}
	
	public static void moveSearchLogin(int err, String errMsg, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (err>5) {
			request.setAttribute("errMsg", errMsg);
			MyUtils.openJSP("user/searchLogin", request, response);
			return;
		}
	}

}