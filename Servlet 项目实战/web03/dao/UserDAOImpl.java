package dao;

import entity.User;

import utils.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
	public boolean specify(String username, String pwd) throws SQLException {
		// 1. ��ȡ���ݿ����Ӷ���
		Connection conn = DBUtils.getConn();
		boolean result = false;
		// 2. ���� SQL ִ�ж���
		String sql = "select count(*) from user where username = ? and pwd = ?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		// 3. �����ʺŵ�����
		pstat.setString(1, username);
		pstat.setString(2, pwd);
		// 4. ִ�� sql
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			if (rs.getInt(1) > 0) {
				result = true;
				break;
			}
		}
		// 5. �ر�����
		DBUtils.close(conn);
		return result;
	}

	// ��ѯ�����û���Ϣ
	public List<User> findAll() throws SQLException {
		List<User> users = new ArrayList<User>();
		Connection conn = DBUtils.getConn();
		String sql = "select * from user";
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery(sql);
		while (rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setUsername(rs.getString("username"));
			u.setPwd(rs.getString("pwd"));
			u.setEmail(rs.getString("email"));
			users.add(u);
		}
		DBUtils.close(conn);
		return users;
	}

	public void addUser(User user) throws SQLException {
		// 1. ��ȡ���ݿ����Ӷ���
		Connection conn = DBUtils.getConn();
		// 2. ���� SQL ִ�ж���
		String sql = "insert into user(username, pwd, email) value(?, ?, ?)";
		PreparedStatement pstat = conn.prepareStatement(sql);
		// 3. �����ʺŵ�����
		pstat.setString(1, user.getUsername());
		pstat.setString(2, user.getPwd());
		pstat.setString(3, user.getEmail());
		// 4. ִ�� sql
		pstat.execute();
		// 5. �ر�����
		DBUtils.close(conn);
	}

	public void delUser(int id) throws SQLException {
		// 1. ��ȡ���ݿ����Ӷ���
		Connection conn = DBUtils.getConn();
		// 2. ���� SQL ִ�ж���
		String sql = "delete from user where id=?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		// 3. �����ʺŵ�����
		pstat.setInt(1, id);
		// 4. ִ�� sql
		pstat.execute();
		// 5. �ر�����
		DBUtils.close(conn);
	}

	public User findById(int id) throws SQLException {
		// 1. ��ȡ���ݿ����Ӷ���
		Connection conn = DBUtils.getConn();
		// 2. ���� SQL ִ�ж���
		String sql = "select * from user where id=?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, id);
		ResultSet rs = pstat.executeQuery();
		User user = new User();
		if (rs.next()) {
			String username = rs.getString("Username");
			String pwd = rs.getString("pwd");
			String email = rs.getString("email");
			user = new User(id, username, pwd, email);
		}
		DBUtils.close(conn);
		return user;
	}

	public void modifyUser(User user) throws SQLException {
		// 1. ��ȡ���ݿ����Ӷ���
		Connection conn = DBUtils.getConn();
		// 2. ���� SQL ִ�ж���
		String sql = "update user set username=?, pwd=?, email=? where id=?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		// 3. �����ʺŵ�����
		pstat.setString(1, user.getUsername());
		pstat.setString(2, user.getPwd());
		pstat.setString(3, user.getEmail());
		pstat.setInt(4, user.getId());
		// 4. ִ�� sql
		pstat.executeUpdate();
		// 5. �ر�����
		DBUtils.close(conn);
	}
}
