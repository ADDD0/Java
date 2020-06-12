package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Employee;

public interface EmployeeDAO {
	// 员工登录
	public boolean login(int employeeId, String password) throws SQLException;

	// 获取所有员工
	public List<Employee> getAllEmployees() throws SQLException;

	// 添加员工
	public void addEmployee(Employee emp) throws SQLException;

	// 删除员工
	public void deleteEmployeeById(int employeeId) throws SQLException;

	// 更改员工
	public void updateEmployee(Employee emp) throws SQLException;

	// 通过 id 搜索员工
	public Employee getEmployeeById(int employeeId) throws SQLException;

	// 通过 name 搜索员工
	public List<Employee> getEmployeesLikeName(String name) throws SQLException;
}
