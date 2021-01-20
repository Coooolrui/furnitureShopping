package com.Coolrui.common;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果集的处理
 * @author Administrator
 *
 */
public interface ResultSetGetter {
	//获取结果集
	public void getterValues(ResultSet rs) throws SQLException;
}
