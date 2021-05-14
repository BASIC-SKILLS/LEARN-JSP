package com.koreait.board4.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVo;

@WebServlet("/board/list")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response)) return;
		
		List<BoardVo> list = BoardDao.selBoardList();
		int listCount = BoardDao.selListCount();
		
		request.setAttribute("list", list);
		request.setAttribute("listCount", listCount);
		
		// <setAttribute> loginUser, list, listCount
		MyUtils.openJSP("board/list", request, response);
	}
	
	}

