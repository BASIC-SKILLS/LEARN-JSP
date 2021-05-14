package com.koreait.board4.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchId")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_Name = request.getParameter("user_Name");
		int gender = MyUtils.getIntParam("gender", request);
		String user_Email = request.getParameter("user_Email");
		
		int emptyCount = MyUtils.getIntParam("emptyCount", request); 
		int noIdCount = MyUtils.getIntParam("noIdCount", request); 

		// 공백확인
		if (MyUtils.isEmpty(user_Name) || MyUtils.isEmpty(user_Email)) {
			emptyCount++;
			if (emptyCount<=5) {
				response.sendRedirect("searchLogin?err=searchId&emptyCount="+emptyCount+"&msg=smtEmpty");
				return;
			}
			if (emptyCount>5) {
				response.sendRedirect("/user/join?msg=noUser");
				return;
			}
			return;
		}

		HisVo hisVo = new HisVo();
		hisVo.setHisName(user_Name);
		hisVo.setHisGender(gender);
		hisVo.setHisEmail(user_Email);

		// hisVo 검사 - id용 - boolean
		boolean checkHisVo4Id = HisDao.checkHisVo4Id(hisVo);

		// id찾기 - 정보 일치
		if (checkHisVo4Id) {
			
			MailSendID.idMailSend(hisVo);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이메일로 ID를 보내드렸어요~^^ 확인해보세요~!!'); location.href='/';</script>");
			out.close();
			
			return;
		}

		// id찾기 - 정보 불일치
		if (!checkHisVo4Id) {
			noIdCount++;
			if (noIdCount<=5) {
				response.sendRedirect("searchLogin?err=searchId&noIdCount="+noIdCount+"&msg=noId");
				return;
			}
			if (noIdCount>5) {
				response.sendRedirect("/user/join?msg=noUser");
				return;
			}
			return;
		}
	
	}

}
