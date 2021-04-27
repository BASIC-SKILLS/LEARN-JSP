package com.koreait.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.vo.BoardVo;
import com.koreait.board.vo.DataBase;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		request.setAttribute("vo", DataBase.list.get(Integer.parseInt(no)));
		
		String jsp = "/WEB-INF/jsps/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String cntnt = request.getParameter("cntnt");
		
		DataBase.list.get(Integer.parseInt(no)).setTitle(title);
		DataBase.list.get(Integer.parseInt(no)).setCntnt(cntnt);
		
		response.sendRedirect("/detail?no="+no);
		
		/* 
		 
		 * <틀린 예 1>
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setCntnt(cntnt);
		
		
		BoardVo data = (BoardVo)DataBase.list.get(Integer.parseInt(no));
		data = vo;
		
		 * <틀린 예 2>
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setCntnt(cntnt);
		DataBase.list.add(Integer.parseInt(no), vo);
		
		 */
	
		
	}

}
