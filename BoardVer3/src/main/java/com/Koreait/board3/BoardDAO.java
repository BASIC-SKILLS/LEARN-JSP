package com.Koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Data Access Object (DB 쿼리 실행 담당)
public class BoardDAO {
	
	public static int insBoard(BoardVo3 vo) {
		Connection con = null; //scope문제 때문에 try catch문 안에서가 아니라 여기서 미리 선언해준다. 
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = " INSERT INTO t_board (title, ctnt) "
				+ " VALUES (?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		// 꼭 close해야 한다. 
		} finally {
			DBUtils.close(con, ps);
		}
		
		return result;
	}
	
	public static List<BoardVo3> selBoardList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVo3> list = new ArrayList();
		
		String sql = " SELECT iboard, title, regdt FROM t_board "
				+ " ORDER BY iboard DESC "; //SELECT문에서 *를 쓰기보다는 컬럼명을 쓰는 것이 좋다. 
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) { //레코드 수만큼 반복하겠다는 의미
				BoardVo3 vo = new BoardVo3();
				list.add(vo); // 여기서 넣어놓고 밑에서 set만 해주는 거니까 set하기 전에 add해줘도 된다. 
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardVo3 selBoardArticle(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVo3 vo = null;
		
		String sql = " SELECT title, ctnt, regdt FROM t_board "
				+ " WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) { //여러개 - while 한개 - if
				vo = new BoardVo3();
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return vo;
	}
	
	public static int delBoardArticle(BoardVo3 vo) {
		System.out.println("DAO delBoardArticle() iboard : " + vo.getIboard());
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = " DELETE FROM t_board "
				+ " WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return result;
	}
	
	public static int updBoardArticle(BoardVo3 vo) {
		System.out.println("DAO updBoardArticle() iboard : " + vo.getIboard());
		System.out.println("DAO updBoardArticle() title : " + vo.getTitle());
		System.out.println("DAO updBoardArticle() ctnt : " + vo.getCtnt());
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = " UPDATE t_board " 
				+ " SET title=?, ctnt=? "
				+ " WHERE iboard=? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return result;
	}
	
	

}
