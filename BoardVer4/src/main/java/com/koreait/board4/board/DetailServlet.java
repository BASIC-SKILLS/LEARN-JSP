package com.koreait.board4.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVo;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response)) return;
		
		BoardVo vo = new BoardVo();
		vo.setIboard(MyUtils.getIntParam("iboard", request));
		BoardDao.selArticle(vo);
		
		request.setAttribute("vo", vo);
		request.setAttribute("yourListCount", BoardDao.selYourListCount(vo.getIuser()));
		request.setAttribute("yourCount", BoardDao.selYourCount(vo));
		
		//<setAttribute> loginUser, BoardVo, yourListCount, yourCount
		MyUtils.openJSP("board/detail", request, response);
	}
}
