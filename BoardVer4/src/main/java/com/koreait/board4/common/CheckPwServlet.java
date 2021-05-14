package com.koreait.board4.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.user.UserDao;
import com.koreait.board4.user.UserVo;

@WebServlet("/checkPw")
public class CheckPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response)) return;
		
		String from = request.getParameter("from");
		String iboard = request.getParameter("iboard");
		String user_Pw = request.getParameter("user_Pw");
		int errCount = MyUtils.getIntParam("errCount", request);
		loginUser.setUser_Pw(user_Pw);
		
		if (UserDao.checkPw(loginUser)) {
			if (from.equals("userInfo")) {
				response.sendRedirect("/user/userInfo?err=done");
				return;
			}
			if (from.equals("detail")) {
				response.sendRedirect("/board/detail?err=done&iboard="+iboard);
				return;
			}
		}
		
		
		errCount++;
		if (errCount>5) {
			response.sendRedirect("/user/logout?errMsg=again");
			return;
		}
		response.sendRedirect("/searchLogin?err=checkPw&from="+from+"&iboard="+iboard+"&errMsg=checkPw&errCount="+errCount);
	}

}
