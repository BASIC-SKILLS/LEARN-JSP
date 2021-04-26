package com.koreait.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.vo.DataBase;

//하나의 경로는 하나의 서블릿과 연결되어 있다. 
@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getParameter - html으로부터 받은 정보 - html에서 받는 값은 무조건 String type
		//setParameter없다. 
		String no = request.getParameter("no");
		System.out.println("no : " + no);
		
		//Attribute는 Object type
		//내가 넣고 꺼내는 정보 - html로 보내기 위해 setAttribute
		//html이 서블릿으로부터 정보를 꺼내는 것 - getAttribute 
		request.setAttribute("vo", DataBase.list.get(Integer.parseInt(no)));
		
		String jsp = "/WEB-INF/jsps/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// Map형식
	// key = value (순서가 없다.)
	// ex ) request
	
	//html에서 받는 값은 무조건 String type 
	//통신 할 때는 문자열만 왔다 갔다
	//문자열이 '값'이기 때문이다.
	//html에서 서버로 객체를 보내봤자, 그 객체는 사용자의 컴퓨터의 메모리에 있는 것일 뿐
	//서버에서는 그 객체가 없다. 
	//그렇기 때문에 html에서 서버로 보낼 때는 request에 문자열만 담아서 보낸다. 
}
