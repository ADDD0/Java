package studentDAO;

import java.util.List;

import pojo.User;

public interface IUserDAO {
	public boolean doInsert(User user) throws Exception;

	public boolean doDelete(int id) throws Exception;

	public boolean doUpdate(int id, User user) throws Exception;

	public User findById(int id) throws Exception;

	public List<User> findByKey(String keyword) throws Exception;

	public List<User> findAllStudent() throws Exception;
}
