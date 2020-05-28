package dao;

import entity.User;

import java.util.List;
import java.sql.SQLException;

public interface UserDAO {
	// 查询所有用户信息
	public List<User> findAll() throws SQLException;

	public void addUser(User user) throws SQLException;

	public void delUser(int id) throws SQLException;

	public User findById(int id) throws SQLException;

	public void modifyUser(User user) throws SQLException;

	public boolean specify(String username, String pwd) throws SQLException;
}
