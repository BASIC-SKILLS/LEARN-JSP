package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.common.DBUtils;
import com.koreait.board4.user.UserDao;
import com.koreait.board4.user.UserVo;

public class BoardDao {
	//UserDao.updYourListCount
	public static void insArticle(UserVo loginUser, BoardVo vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board(title, ctnt, iuser) "
				+ " VALUES(?,?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIuser());
			ps.executeUpdate();
			UserDao.updYourListCount(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static List<BoardVo> selBoardList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		String sql = " SELECT B.iboard, B.title, B.regdt, U.user_Id, U.user_Name " 
				+ " FROM t_board B "
				+ " LEFT JOIN t_user U "
				+ " ON B.iuser = U.iuser "
				+ " ORDER BY B.iboard DESC ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				BoardVo voShow = new BoardVo();
				list.add(voShow);
				voShow.setIboard(rs.getInt("iboard"));
				voShow.setTitle(rs.getString("title"));
				voShow.setRegdt(rs.getString("regdt"));
				voShow.setUser_Name(rs.getString("user_Name"));
				voShow.setUser_Id(rs.getString("user_Id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int selYourListCount(int iUser) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT count(*) FROM t_board WHERE iuser=?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iUser);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
	
	public static int selYourCount(BoardVo bdVo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;
		
		String sql = " SELECT iboard FROM t_board WHERE iuser=?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bdVo.getIuser());
			rs = ps.executeQuery();
			while (rs.next()) {
				count++;
				if(rs.getInt("iboard")==bdVo.getIboard()) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return count;
	}
	
	
	public static BoardVo selArticle(BoardVo vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT B.iboard, B.title, B.ctnt, B.regdt, B.iUser, U.user_Id, U.user_Name "
				+ " FROM t_board B "
				+ " LEFT JOIN t_user U "
				+ " ON B.iUser = U.iuser "
				+ " WHERE B.iboard=? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			rs = ps.executeQuery();
			if (rs.next()) {
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iUser"));
				vo.setUser_Id(rs.getString("user_Id"));
				vo.setUser_Name(rs.getString("user_Name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return vo;
	}
	
	//UserDao.updYourDelCount
	public static int delArticle(UserVo loginUser, BoardVo vo) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = " DELETE FROM t_board "
				+ " WHERE iboard=? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getIboard());
			result = ps.executeUpdate();
			UserDao.updYourDelCount(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return result;
	}
	
	public static int selListCount() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT count(*) FROM t_board";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return 0;
	}
	
	//UserDao.updModCount
	public static void updArticle(UserVo loginUser, BoardVo vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_board "
				+ " SET title=?, ctnt=? " 
				+ " WHERE iboard=? "
				+ " AND iuser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			ps.setInt(4, loginUser.getiUser());
			ps.executeUpdate();
			UserDao.updModCount(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
