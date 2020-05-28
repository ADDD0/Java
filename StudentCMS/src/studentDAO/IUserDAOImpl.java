package studentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.User;
import util.DBConnection;
import util.DataConvert;

public class IUserDAOImpl implements IUserDAO {
	private DBConnection dbc = null;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	public IUserDAOImpl() {
		this.dbc = new DBConnection();
		this.conn = dbc.getConnection();
	}

	// 增加人员
	public boolean doInsert(User user) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO useres(id,name,sex,birthday) VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getSex());
			pstmt.setDate(4, new DataConvert().uDToSD(user.getBirthday()));
			if (pstmt.executeUpdate() > 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	// 按照id删除
	public boolean doDelete(int id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM useres WHERE id=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() > 0) // 至少已经更新了一行
				flag = true;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	// 修改人员信息
	public boolean doUpdate(int id, User user) throws Exception {
		boolean flag = false;
		String sql = "UPDATE useres SET name=?,sex=?,birthday=? WHERE id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getSex());
			pstmt.setDate(3, new DataConvert().uDToSD(user.getBirthday()));
			pstmt.setInt(4, user.getId());
			if (pstmt.executeUpdate() > 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	// 按id查询
	public User findById(int id) throws Exception {
		User user = null;
		String sql = "SELECT id,name,sex,birthday FROM useres WHERE id=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(id);
				user.setId(rs.getInt(1)); // rs.getInt(1)获取数据库字段内容
				user.setName(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setBirthday(rs.getDate(4));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	// 按照关键字查询
	public List<User> findByKey(String keyword) throws Exception {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM useres WHERE name LIKE ? OR sex LIKE ?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User(keyword);
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setBirthday(rs.getDate(4));
				list.add(user); // 将所有的内容插入集合
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 查询全部学员信息
	public List<User> findAllStudent() throws Exception {
		List<User> list = new ArrayList<User>();
		User user = null;
		String sql = "SELECT * FROM useres ORDER BY id";
		try {
			pstmt = this.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setBirthday(rs.getDate(4));
				list.add(user);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
