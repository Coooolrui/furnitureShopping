package com.Coolrui.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	/**
	 * 通用的增删改模板
	 *
	 * @return
	 */
	public static int update(String sql, PreparedStatementSetter setter) {
		// 1、2
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstat = null;
		int rows = 0;

		try {
			conn.setAutoCommit(false);
			// 3
			pstat = conn.prepareStatement(sql);
			if (setter != null) {
				setter.setterValues(pstat);
			}
			// 4、
			rows = pstat.executeUpdate();
			//提交
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			// 6、
			DBUtils.close(conn, pstat);
		}

		return rows;
	}

	public static void query(String sql, PreparedStatementSetter setter, ResultSetGetter getter) {
		// 1、2
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstat = null;
		ResultSet rs = null;

		try {
			//3
			pstat = conn.prepareStatement(sql);
//			sql = "select * from t_user where id=?";
//			pstat.setInt(1, 2);
			//如果占位符的处理不为空，我们需要处理占位符
			if(setter!=null) {
				setter.setterValues(pstat);
			}

			//4
			rs = pstat.executeQuery();
			//5
			if(getter!=null) {
				getter.getterValues(rs);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//6
			DBUtils.close(conn, pstat, rs);
		}
	}


}
