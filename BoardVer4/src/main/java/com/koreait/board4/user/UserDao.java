package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board4.common.DBUtils;


public class UserDao {
	public static void insUser(UserVo vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_user(user_Id, user_Pw, user_Name, gender, user_Email) " + " VALUES(?,?,?,?,?) ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUser_Id());
			ps.setString(2, vo.getUser_Pw());
			ps.setString(3, vo.getUser_Name());
			ps.setInt(4, vo.getGender());
			ps.setString(5, vo.getUser_Email());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}

	public static int checkLogin(UserVo vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT user_Pw, iUser, user_Name " + " FROM  t_user " + " WHERE user_Id=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUser_Id());
			rs = ps.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(vo.getUser_Pw(), rs.getString("user_Pw"))) {
					vo.setUser_Pw(null);
					vo.setiUser(rs.getInt("iUser"));
					vo.setUser_Name("user_Name");
					return 1;
				} else {
					return 3;
				}
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

	public static UserVo sellAllUserVo(UserVo loginUser) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT iUser, user_Id, user_Pw, user_Name, gender, regdt, user_Email, listCount, delCount, modCount "
				+ " FROM  t_user " + " WHERE iUser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, loginUser.getiUser());
			rs = ps.executeQuery();
			if (rs.next()) {
				loginUser.setiUser(rs.getInt("iUser"));
				loginUser.setUser_Id(rs.getString("user_Id"));
				loginUser.setUser_Pw(rs.getString("user_Pw"));
				loginUser.setUser_Name(rs.getString("user_Name"));
				loginUser.setGender(rs.getInt("gender"));
				loginUser.setRegdt(rs.getString("regdt"));
				loginUser.setUser_Email(rs.getString("user_Email"));
				loginUser.setListCount(rs.getInt("listCount"));
				loginUser.setDelCount(rs.getInt("delCount"));
				loginUser.setModCount(rs.getInt("modCount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return loginUser;
	}

	// BoardDao.insArticle()에서만 쓰인다.
	public static void updYourListCount(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_user " + " SET listCount=? " + " WHERE iUser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, (loginUser.getListCount() + 1));
			ps.setInt(2, loginUser.getiUser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}

	// BoardDao.delArticle() 에서만 쓰인다.
	public static void updYourDelCount(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_user " + " SET delCount=? " + " WHERE iUser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, loginUser.getDelCount() + 1);
			ps.setInt(2, loginUser.getiUser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}

	// BoardDao.updArticle() 에서만 쓰인다.
	public static void updModCount(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_user " + " SET modCount=? " + " WHERE iUser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, loginUser.getModCount() + 1);
			ps.setInt(2, loginUser.getiUser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}

	public static boolean checkPw(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;

		String sql = " SELECT user_Pw " + " FROM  t_user " + " WHERE iUser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, loginUser.getiUser());
			rs = ps.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(loginUser.getUser_Pw(), rs.getString("user_Pw"))) {
					loginUser.setUser_Pw(null);
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	
	public static void delUser(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM t_user "
				+ " WHERE user_Id=? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, loginUser.getUser_Id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static void updPw(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_user " + " SET user_Pw=?" + " WHERE iUser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, loginUser.getUser_Pw());
			ps.setInt(2, loginUser.getiUser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static void updEmail(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_user " + " SET user_Email=?" + " WHERE iUser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, loginUser.getUser_Email());
			ps.setInt(2, loginUser.getiUser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static void updInfo(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " UPDATE t_user " + " SET user_Email=?, user_Pw=? " + " WHERE iUser=? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, loginUser.getUser_Email());
			ps.setString(2, loginUser.getUser_Pw());
			ps.setInt(3, loginUser.getiUser());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
	
	public static boolean confirmId(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT user_Id " + " FROM  t_user ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (loginUser.getUser_Id().equals(rs.getString("user_Id"))) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return true;
	}
	
	
	
	public static boolean confirmEmail(UserVo loginUser) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT user_Email " + " FROM  t_user ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (loginUser.getUser_Email().equals(rs.getString("user_Email"))) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return true;
	}
	
}