package com.Koreait.board3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String jspNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/views/" + jspNm + ".jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	public static int parseStrToInt(String num) {
		try {
			return Integer.parseInt(num);
		} catch(Exception e) {
			return 0;
		}
	}
	
	public static int getParamInt(HttpServletRequest request, String key) {
		return parseStrToInt(request.getParameter(key));
	}
}
