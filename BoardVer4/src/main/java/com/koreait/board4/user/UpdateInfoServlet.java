package com.koreait.board4.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.common.MyUtils;

@WebServlet("/user/updateInfo")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response))
			return;

		// <setAttribute> loginUser
		MyUtils.openJSP("/user/updateInfo", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVo loginUser = MyUtils.getNewLoginUser(request);
		if (!MyUtils.checkLogin(loginUser, request, response))
			return;

		String user_Email = request.getParameter("user_Email");
		String user_Pw = request.getParameter("user_Pw");
		String confirmPw = request.getParameter("confirmPw");
		int emptyCount = MyUtils.getIntParam("emptyCount", request);

		// 이메일과 비밀번호 공백 확인
		if ((user_Email == null && user_Pw == null) || (user_Email.equals("") && user_Pw.equals(""))) {
			emptyCount++;
			if (emptyCount <= 5) {
				response.sendRedirect("updateInfo?emptyCount=" + emptyCount + "&&msg=allEmpty");
				return;
			}
			if (emptyCount > 5) {
				response.sendRedirect("/user/logout");
				return;
			}
			return;
		}

		// 이메일 공백 비밀번호만 변경
		boolean confirmPws = MyUtils.confirmPws(user_Pw, confirmPw);

		if (MyUtils.isEmpty(user_Email) && !confirmPws) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호 확인이 일치하지 않아요~! 다시 수정 해보세요~!'); history.back();</script>");
			out.close();
			return;
		}

		String bcryptPw = BCrypt.hashpw(user_Pw, BCrypt.gensalt());
		loginUser.setUser_Pw(bcryptPw);

		if (MyUtils.isEmpty(user_Email) && confirmPws) {
			UserDao.updPw(loginUser);
			response.sendRedirect("userInfo?msg=noEmail");
			return;
		}

		// 이메일만 변경 비밀번호 공백 | 이메일 공백확인 완료 | 비밀번호 일치 확인 완료
		loginUser.setUser_Email(user_Email);
		boolean confirmEmail = UserDao.confirmEmail(loginUser);

		if (!confirmEmail) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('중복된 이메일 입니다! 다른 이메일로 시도해보세요!'); history.back();</script>");
			out.close();
			return;
		}

		if (MyUtils.isEmpty(user_Pw) || MyUtils.isEmpty(confirmPw)) {
			UserDao.updEmail(loginUser);
			response.sendRedirect("userInfo?msg=noPw");
			return;
		}

		// 이메일 비밀번호 모두 변경 | 이메일 공백확인 완료 | 비밀번호 공백확인 완료 | 비밀번호 일치 확인 완료 | 이메일 중복 확인 완료

		UserDao.updInfo(loginUser);

		response.sendRedirect("userInfo");
	}

}
