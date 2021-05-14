package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;

@WebServlet("/user/userInfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response)) return;
		
		//<setAttribute> loginUser
		MyUtils.openJSP("user/userInfo", request, response);
	}

}
