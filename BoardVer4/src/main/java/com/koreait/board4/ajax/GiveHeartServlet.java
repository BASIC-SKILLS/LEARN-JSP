package com.koreait.board4.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.common.MyUtils;

@WebServlet("/ajax/giveHeart")
public class GiveHeartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iuser = MyUtils.getLoginUserIUSER(request);
		int iboard = MyUtils.getIntParam("iboard", request);
		
		int fav = AjaxDao.selFav(iuser, iboard);
		System.out.println("FirstgiveHeart fav :"+fav);
		if (fav==0) {
			heartResult(0, response);
			return;
		} else if (fav>0) {
			heartResult(1, response);
			return;
		}
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iuser = MyUtils.getLoginUserIUSER(request);
		int iboard = MyUtils.getIntParam("iboard", request);
		
		int fav = AjaxDao.selFav(iuser, iboard);
		System.out.println("/ajax/giveHeart fav :"+fav);
		if (fav==0) {
			AjaxDao.insFav(iuser, iboard);
			heartResult(1, response);
			return;
		} else if (fav>0) {
			AjaxDao.delFav(iuser, iboard);
			heartResult(2, response);
			return;
		}
	}
	
	private static void heartResult(int result, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("{\"result\": " + result + "}");
		out.close();
	}

}
