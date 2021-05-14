package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVo;

@WebServlet("/board/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response)) return;
		
		BoardVo vo = new BoardVo();
		int iboard = MyUtils.getIntParam("iboard", request);
		vo.setIboard(iboard);
		int result = BoardDao.delArticle(loginUser, vo);
		if ( result > 0 ) {
			response.sendRedirect("list");
			return;
		}
		
		response.sendRedirect("detail?iboard="+iboard);
	}

}
