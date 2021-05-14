package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVo;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response)) return;
		
		//<setAttribute> loginUser
		MyUtils.openJSP("board/write", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVo vo = new BoardVo();
		vo.setIuser(loginUser.getiUser());
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		BoardDao.insArticle(loginUser, vo);
		response.sendRedirect("list");
	}
}
