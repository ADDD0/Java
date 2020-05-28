package dao;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpListJDBC {
	public static void main(String[] args) throws SQLException {
		// ʹ�� JDBC ʵ�ֲ�ѯ t_emp ���е��������ݲ�����ڿ���̨
		// 1. ��ȡ���ݿ�����
		Connection conn = DBUtils.getConn();
		// 2. ���� SQL ִ�ж���
		Statement stat = conn.createStatement();
		String sql = "select * from t_emp";
		// 3. ִ�� sql ��䲢��ȡ��������� resultSet
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			System.out.println("ID=" + rs.getInt("id") + ",name=" + rs.getString("name") + ",salary="
					+ rs.getDouble("salary") + ",age=" + rs.getInt("age"));
		}
		DBUtils.close(conn);
	}
}
