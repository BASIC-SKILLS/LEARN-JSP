package com.koreait.board.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.vo.BoardVo;
import com.koreait.board.vo.DataBase;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/jsps/write.jsp";
		
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //post방식 인코딩
		
		//getParameter - html로 부터 받은 정보
		String title = request.getParameter("title");
		String cntnt = request.getParameter("cntnt");
		
		BoardVo vo = new BoardVo();
		
		vo.setTitle(title);
		vo.setCntnt(cntnt);
		
		DataBase.list.add(vo);
		
		response.sendRedirect("/list"); //get방식으로 주소 이동 
	}
	
	//get방식은 화면 이동 

}
