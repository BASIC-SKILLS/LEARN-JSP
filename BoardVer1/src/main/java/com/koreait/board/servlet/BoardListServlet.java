package com.koreait.board.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.vo.DataBase;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dataList", DataBase.list);
		
		String jsp = "/WEB-INF/jsps/list.jsp";
		
		/*
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		*/
		
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
