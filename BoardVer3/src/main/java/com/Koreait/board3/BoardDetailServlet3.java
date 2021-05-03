package com.Koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail3")
public class BoardDetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		System.out.println("/detail3 iboard : " + iboard);
		
		BoardVo3 vo = BoardDAO.selBoardArticle(Integer.parseInt(iboard));
		
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/WEB-INF/views/detail3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
