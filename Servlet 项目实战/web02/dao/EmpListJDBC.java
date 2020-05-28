package dao;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpListJDBC {
	public static void main(String[] args) throws SQLException {
		// 使用 JDBC 实现查询 t_emp 表中的所有数据并输出在控制台
		// 1. 获取数据库连接
		Connection conn = DBUtils.getConn();
		// 2. 创建 SQL 执行对象
		Statement stat = conn.createStatement();
		String sql = "select * from t_emp";
		// 3. 执行 sql 语句并获取结果集对象 resultSet
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			System.out.println("ID=" + rs.getInt("id") + ",name=" + rs.getString("name") + ",salary="
					+ rs.getDouble("salary") + ",age=" + rs.getInt("age"));
		}
		DBUtils.close(conn);
	}
}
