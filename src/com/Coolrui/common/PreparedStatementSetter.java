package com.Coolrui.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 设置占位符
 * @author Administrator
 *
 */
public interface PreparedStatementSetter {
	public void setterValues(PreparedStatement pstat) throws SQLException;
}
