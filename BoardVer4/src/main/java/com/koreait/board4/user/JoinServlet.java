package com.koreait.board4.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.common.MyUtils;


@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_Id = request.getParameter("user_Id");
		String user_Name = request.getParameter("user_Name");
		int gender = MyUtils.getIntParam("gender", request);
		String user_Email = request.getParameter("user_Email");
		String user_Pw = request.getParameter("user_Pw");
		String confirmPw = request.getParameter("confirmPw");
		
		//항목 공백 확인
		if (MyUtils.isEmpty(user_Id) || MyUtils.isEmpty(user_Name) 
				|| MyUtils.isEmpty(user_Email) || MyUtils.isEmpty(user_Pw) ) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('어떤 항목이 비어있습니다. 모두 채우셔야 회원가입이 가능합니다.'); history.back();</script>");
			out.close();
			return;
		}
		
		if (!MyUtils.confirmPws(user_Pw, confirmPw)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호 확인이 일치하지 않아요~! 다시 회원가입 해보세요~!'); history.back();</script>");
			out.close();
			return;
		};
	
		String bcryptPw = BCrypt.hashpw(user_Pw, BCrypt.gensalt());
		
		UserVo vo = new UserVo();
		vo.setUser_Id(user_Id);
		vo.setUser_Pw(bcryptPw);
		vo.setUser_Name(user_Name);
		vo.setGender(gender);
		vo.setUser_Email(user_Email);
		
		if(!UserDao.confirmId(vo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('중복된 아이디 입니다! 다른 아이디로 시도해보세요!'); history.back();</script>");
			out.close();
			return;
		};
		
		if(!UserDao.confirmEmail(vo)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('중복된 이메일 입니다! 다른 이메일로 시도해보세요!'); history.back();</script>");
			out.close();
			return;
		};
		
		UserDao.insUser(vo);
		response.sendRedirect("login");
	}

}