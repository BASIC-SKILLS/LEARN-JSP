package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.user.UserDao;
import com.koreait.board4.user.UserVo;

public class MyUtils {
	public static void openJSP(String jspNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/views/" + jspNm + ".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	public static int parseStrInt(String param) {
		try {
			return Integer.parseInt(param);
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static UserVo getLoginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (UserVo) session.getAttribute("loginUser");
	}
	
	public static int getIntParam(String param, HttpServletRequest request) {
		return parseStrInt(request.getParameter(param));
	}
	
	public static int getLoginUserIUSER(HttpServletRequest request) {
		return getLoginUser(request).getiUser();
	}
	
	public static boolean checkLogin(UserVo loginUser, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if (loginUser == null) {
			openJSP("user/login", request, response);
			return false;
		}
		return true;
	}
	
	public static UserVo getNewLoginUser(HttpServletRequest request) {
		UserVo loginUser = MyUtils.getLoginUser(request);
		HttpSession session = request.getSession();
		UserVo newLoginUser = UserDao.sellAllUserVo(loginUser);
		session.setAttribute("loginUser", newLoginUser);
		return (UserVo) session.getAttribute("loginUser");
	}
	
	public static boolean confirmPws(String pwd, String newPwd) {
		if (pwd.equals(newPwd)) return true;
		return false;
	}
}