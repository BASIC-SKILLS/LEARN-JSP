package com.koreait.board4.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/user/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errMsg = request.getParameter("errMsg");
		HttpSession session = request.getSession();
		session.invalidate();
		if (errMsg!=null && errMsg.equals("again")) {
			response.sendRedirect("login?errMsg=again");
			return;
		}
		response.sendRedirect("login");
	}
}
