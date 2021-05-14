package com.koreait.board4.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.MyUtils;

@WebServlet("/user/updateInfo")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response)) return;
		
		//<setAttribute> loginUser
		MyUtils.openJSP("/user/updateInfo", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response)) return;
		
		String user_Email = request.getParameter("user_Email");
		String user_Pw = request.getParameter("user_Pw");
		String confirmPw = request.getParameter("confirmPw");
		
		loginUser.setUser_Email(user_Email);
		
		if(!UserDao.confirmEmail(loginUser))  {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('중복된 이메일 입니다! 다른 이메일로 시도해보세요!'); history.back();</script>");
			out.close();
			return;
		}
		
		if (user_Pw==null || confirmPw==null || user_Pw=="" || confirmPw=="") {
			UserDao.updEmail(loginUser);
			response.sendRedirect("userInfo?msg=noPw");
			return;
		}
		
		
		if (!MyUtils.confirmPws(user_Pw, confirmPw)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호 확인이 일치하지 않아요~! 다시 수정 해보세요~!'); history.back();</script>");
			out.close();
			return;
		};
		
		String bcryptPw = BCrypt.hashpw(user_Pw, BCrypt.gensalt());
		loginUser.setUser_Pw(bcryptPw);
	
		UserDao.updInfo(loginUser);
		
		response.sendRedirect("userInfo");
	}

}
