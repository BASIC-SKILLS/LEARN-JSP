package com.koreait.board4.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class HisDao {
	public static boolean checkHisVo4Id(HisVo hisVo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT user_Id " + " FROM  t_user " 
				+ " WHERE user_Name=? AND gender=? AND user_Email=?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, hisVo.getHisName());
			ps.setInt(2, hisVo.getHisGender());
			ps.setString(3, hisVo.getHisEmail());
			rs = ps.executeQuery();
			if (rs.next()) {
				hisVo.setHisId(rs.getString("user_Id"));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return false;
	}
	
	public static boolean checkHisVo4IPw(HisVo hisVo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT user_Name " + " FROM  t_user " 
				+ " WHERE user_Name=? AND gender=? AND user_Email=? AND user_Id=?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, hisVo.getHisName());
			ps.setInt(2, hisVo.getHisGender());
			ps.setString(3, hisVo.getHisEmail());
			ps.setString(4, hisVo.getHisId());
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return false;
	}
}
