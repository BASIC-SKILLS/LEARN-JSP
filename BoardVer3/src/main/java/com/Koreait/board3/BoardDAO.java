package com.Koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Data Access Object (DB 쿼리 실행 담당)
public class BoardDAO {
	
	public static int insertBoard(BoardVo3 vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board (title, ctnt)"
				+ " VALUES (?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
		} catch (Exception e) {
			e.printStackTrace();
		// 꼭 close해야 한다. 
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}

}
