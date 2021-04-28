package com.koreait.board2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
//JSTL, EL -> 내장객체
//pageContext
//request
//session
//application

//jsp에서 ${}은 주석처리가 되지 않는다. 
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		request.setAttribute("data", Database.db.get(Integer.parseInt(no)));
		request.setAttribute("age", 26);
		request.setAttribute("owner", "장현진");
		request.setAttribute("str", "내장객체");
		
		String jsp = "/WEB-INF/jsps/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
