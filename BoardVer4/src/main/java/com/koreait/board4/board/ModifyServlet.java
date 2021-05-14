package com.koreait.board4.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.common.MyUtils;
import com.koreait.board4.user.UserVo;


@WebServlet("/board/mod")
public class ModifyServlet extends HttpServlet {
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
		MyUtils.openJSP("board/mod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response)) return;
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iboard = MyUtils.getIntParam("iboard", request);
		
		if (MyUtils.isEmpty(title)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('제목이 비어있으면 글 수정이 불가합니다.'); history.back();</script>");
			out.close();
			return;
		}
		
		BoardVo vo = new BoardVo();
		vo.setIboard(iboard);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		BoardDao.updArticle(loginUser, vo);
		
		response.sendRedirect("detail?iboard="+iboard);
	}

}
