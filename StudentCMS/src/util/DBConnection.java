package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	InputStream in = DBConnection.class.getClassLoader().getResourceAsStream("database.properties");
	Properties prop = new Properties();
	Connection conn = null;
	public static String DBDRIVER;
	public static String DBURL;
	public static String DBUSER;
	public static String DBPASS;

	public DBConnection() {
		try {
			prop.load(in);
			DBDRIVER = prop.getProperty("driver");
			DBURL = prop.getProperty("url");
			DBUSER = prop.getProperty("user");
			DBPASS = prop.getProperty("password");
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}
}
