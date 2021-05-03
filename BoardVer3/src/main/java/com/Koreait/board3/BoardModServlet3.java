package com.Koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod3")
public class BoardModServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		System.out.println("/mod3 doGet() iboard : " + iboard);
		
		BoardVo3 vo = BoardDAO.selBoardArticle(Integer.parseInt(iboard));
		
		request.setAttribute("vo", vo);
		request.getRequestDispatcher("/WEB-INF/views/mod3.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		System.out.println("/mod3 doPost() iboard : " + iboard);
		System.out.println("/mod3 doPost() title : " + title);
		System.out.println("/mod3 doPost() ctnt : " + ctnt);
		
		BoardVo3 vo = new BoardVo3();
		vo.setIboard(Integer.parseInt(iboard));
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		if (BoardDAO.updBoardArticle(vo) > 0) {
			response.sendRedirect("/detail3?iboard=" + iboard);
			System.out.println("글이 수정됐어요~^^! ");
		} else {
			System.out.println("글이 수정되지 않았어요. ㅜㅜ ");
		}
	}

}
