package com.Koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del3")
public class BoardDelServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		BoardVo3 vo = new BoardVo3();
		vo.setIboard(Integer.parseInt(iboard));
		
		System.out.println("/del3 iboard : " + iboard);
		
		int result = BoardDAO.delBoardArticle(vo);
		
		if (result > 0) {
			System.out.println("글이 삭제 됐어요~^^");
			response.sendRedirect("/list3");
		} else {
			System.out.println("해당 글을 삭제하는 데 실패하였습니다.");
		}
	}
}
