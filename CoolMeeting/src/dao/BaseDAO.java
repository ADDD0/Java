package dao;

import java.sql.Connection;
import java.sql.SQLException;

import utils.DBUtils;

public class BaseDAO {
	private Connection conn;

	// 获取数据库连接
	public Connection getConn() throws SQLException {
		conn = DBUtils.getConn();
		return conn;
	}

	// 关闭数据库连接
	public void closeConn() throws SQLException {
		DBUtils.close(conn);
	}
}
