
/*
 * @(#)JDBCDemo.java	2000/06/18
 */

import java.sql.*;

/**
 * 演示JDBC操作数据库的各项功能,包括表的创建(CREATE)和删除(DROP),
 * 记录的插入(INSERT),选择(SELECT)和更改(UPDATE)等操作
 * 
 * @version 1.00 2000/06/18
 * @author TangDashi
 * @since JDK1.2
 */
public class JDBCDemo {
	public static void main(String[] args) {
		try {
			Statement stmt;
			PreparedStatement pstmt;
			ResultSet rs;

			// 加载jdbc-odbc桥驱动程序
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// 定义JDBC URL
			String url = "jdbc:odbc:JDBCDemo";

			// 得到与数据库的连接
			java.sql.Connection con = DriverManager.getConnection(url);

			// 显示URL和连接信息
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);

			// 得到一个Statement对象
			stmt = con.createStatement();

			// 如果表DemoTable已经存在,则删除;否则,抛出一个异常
			System.out.println("DROP TABLE DemoTable, if it exists.");
			try {
				stmt.executeUpdate("DROP TABLE DemoTable");
			} catch (Exception e) {
				System.out.print(e);
				System.out.println("No existing table to delete");
			}

			// 在数据库中创建一个表DemoTable
			stmt.executeUpdate("CREATE TABLE DemoTable (" + "test_id int,test_val char(15) not null)");
			System.out.println("table DemoTable created!");

			// 在表中插入一些值
			stmt.executeUpdate("INSERT INTO DemoTable (" + "test_id, test_val) VALUES(1, 'One')");
			stmt.executeUpdate("INSERT INTO DemoTable (" + "test_id, test_val) VALUES(2, 'Two')");
			stmt.executeUpdate("INSERT INTO DemoTable (" + "test_id, test_val) VALUES(3, 'Three')");
			stmt.executeUpdate("INSERT INTO DemoTable (" + "test_id, test_val) VALUES(4, 'Four')");
			stmt.executeUpdate("INSERT INTO DemoTable (" + "test_id, test_val) VALUES(5, 'Five')");

			// 得到另一个Statement对象
			stmt = con.createStatement();

			// 查询数据库中的表DemoTable,得到以test_id排序后的所有记录,并存储在ResultSet对象rs中
			rs = stmt.executeQuery("SELECT * from DemoTable ORDER BY test_id");

			// 显示表DemoTable中的所有记录
			System.out.println("Display all results:");
			while (rs.next()) {
				int theInt = rs.getInt("test_id");
				String str = rs.getString("test_val");
				System.out.println("\ttest_id= " + theInt + "\tstr = " + str);
			}

			// 创建已准备好的语句,更新DemoTable表中某条记录的test_val字段
			// 已准备好的语句接受两个参数
			pstmt = con.prepareStatement("UPDATE DemoTable SET test_val = ? WHERE test_id = ?");

			// 更改表DemoTable中的第2条记录的test_val字段的值
			// 填充UPDATE语句中的"?",并执行UPDATE语句
			pstmt.setString(1, "Hello!");
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			System.out.println("Update row number 2: OK.");

			// 显示表DemoTable中更新后的第2条记录
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from DemoTable ORDER BY test_id");
			System.out.println("Display row 2:");
			if (rs.next() && rs.next()) {
				int theInt = rs.getInt("test_id");
				String str = rs.getString("test_val");
				System.out.println("\ttest_id= " + theInt + "\tstr = " + str);
			}
			// 关闭与数据库的连接
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}