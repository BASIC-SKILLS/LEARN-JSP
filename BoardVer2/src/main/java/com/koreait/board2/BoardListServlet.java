package com.koreait.board2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVo> list = Database.db;
		request.setAttribute("list", list);
		
		String jsp = "/WEB-INF/jsps/list.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
		//get방식의 역할은 화면 띄우기
		//post방식의 역할은 프로세스(처리) 후 get방식으로 이동해서 화면을 띄우게 한다.  
	}

}
