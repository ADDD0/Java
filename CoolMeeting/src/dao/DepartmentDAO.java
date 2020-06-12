package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Department;

public interface DepartmentDAO {
	// 获取所有部门
	public List<Department> getAllDepartments() throws SQLException;

	// 添加部门
	public void addDepartment(Department dept) throws SQLException;

	// 删除部门
	void deleteDepartmentById(int departmentId) throws SQLException;

	// 更改部门
	public void updateDepartment(Department dept) throws SQLException;

	// 搜索部门
	public Department getDepartmentById(int departmentId) throws SQLException;
}
