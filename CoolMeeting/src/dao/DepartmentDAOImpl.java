package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Department;

public class DepartmentDAOImpl extends BaseDAO implements DepartmentDAO {
	@Override
	public List<Department> getAllDepartments() throws SQLException {
		// sql 语句
		String sql = "select * from department";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// 获取结果
		ResultSet rs = ps.executeQuery();
		ArrayList<Department> list = new ArrayList<Department>();
		while (rs.next()) {
			// 获取一条数据
			int departmentId = rs.getInt("departmentId");
			String departmentName = rs.getString("departmentName");

			Department dept = new Department(departmentId, departmentName);
			System.out.println(dept);
			list.add(dept);
		}
		closeConn();
		return list;
	}

	@Override
	public void addDepartment(Department dept) throws SQLException {
		// sql 语句
		String sql = "insert into department values(?,?)";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, dept.getDepartmentId());
		ps.setString(2, dept.getDepartmentName());
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public void deleteDepartmentById(int departmentId) throws SQLException {
		// sql 语句
		String sql = "delete from department where departmentId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, departmentId);
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public void updateDepartment(Department dept) throws SQLException {
		// sql 语句
		String sql = "update department set departmentName=? where departmentId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setString(1, dept.getDepartmentName());
		ps.setInt(2, dept.getDepartmentId());
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public Department getDepartmentById(int departmentId) throws SQLException {
		// sql 语句
		String sql = "select * from department where departmentId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, departmentId);
		// 获取结果
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// 获取一条数据
			String departmentName = rs.getString("departmentName");

			Department dept = new Department(departmentId, departmentName);
			System.out.println(dept);
			closeConn();
			return dept;
		}
		closeConn();
		return null;
	}
}
