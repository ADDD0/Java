package utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.util.Properties;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.InputStream;
import java.io.IOException;

public class DBUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static BasicDataSource dataSource = new BasicDataSource();

	static {
		Properties prop = new Properties();

		InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("utils/jdbc.properties");
		try {
			prop.load(is);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			// ��������Դ����
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ͨ�����ӳػ�ȡ����
	public static Connection getConn() throws SQLException {
		return dataSource.getConnection();
	}

	// �ر����ӵķ���
	public static void close(Connection conn) throws SQLException {
		// �� Connection ����Ϊ null ��ʱ��ر�����
		if (conn != null) {
			conn.close();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtils.getConn();
		System.out.println(conn);
	}
}
