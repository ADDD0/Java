package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;

public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {
	@Override
	public boolean login(int employeeId, String password) throws SQLException {
		// sql 语句
		String sql = "select count(*) from employee where employeeId = ? and password = ?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, employeeId);
		ps.setString(2, password);
		// 获取结果
		ResultSet rs = ps.executeQuery();
		boolean result = false;
		while (rs.next()) {
			if (rs.getInt(1) > 0) {
				result = true;
				break;
			}
		}
		closeConn();
		return result;
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		// sql 语句
		String sql = "select * from employee";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// 获取结果
		ResultSet rs = ps.executeQuery();
		ArrayList<Employee> list = new ArrayList<Employee>();
		while (rs.next()) {
			// 获取一条数据
			int employeeId = rs.getInt("employeeId");
			String employeeName = rs.getString("employeeName");
			String username = rs.getString("username");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			int employeeStatus = rs.getInt("employeeStatus");
			int departmentId = rs.getInt("departmentId");
			String password = rs.getString("password");
			int role = rs.getInt("role");

			Employee emp = new Employee(employeeId, employeeName, username, phone, email, employeeStatus, departmentId,
					password, role);
			System.out.println(emp);
			list.add(emp);
		}
		closeConn();
		return list;
	}

	@Override
	public void addEmployee(Employee emp) throws SQLException {
		// sql 语句
		String sql = "insert into employee values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, emp.getEmployeeId());
		ps.setString(2, emp.getEmployeeName());
		ps.setString(3, emp.getUsername());
		ps.setString(4, emp.getPhone());
		ps.setString(5, emp.getEmail());
		ps.setInt(6, emp.getEmployeeStatus());
		ps.setInt(7, emp.getDepartmentId());
		ps.setString(8, emp.getPassword());
		ps.setInt(9, emp.getRole());
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public void deleteEmployeeById(int employeeId) throws SQLException {
		// sql 语句
		String sql = "delete from employee where employeeId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, employeeId);
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		// sql 语句
		String sql = "update employee set employeeName=?,username=?,phone=?,email=?,employeeStatus=?,departmentId=?,password=?,role=? where employeeId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setString(1, emp.getEmployeeName());
		ps.setString(2, emp.getUsername());
		ps.setString(3, emp.getPhone());
		ps.setString(4, emp.getEmail());
		ps.setInt(5, emp.getEmployeeStatus());
		ps.setInt(6, emp.getDepartmentId());
		ps.setString(7, emp.getPassword());
		ps.setInt(8, emp.getRole());
		ps.setInt(9, emp.getEmployeeId());
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public Employee getEmployeeById(int employeeId) throws SQLException {
		// sql 语句
		String sql = "select * from employee where employeeId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, employeeId);
		// 获取结果
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// 获取一条数据
			String employeeName = rs.getString("employeeName");
			String username = rs.getString("username");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			int employeeStatus = rs.getInt("employeeStatus");
			int departmentId = rs.getInt("departmentId");
			String password = rs.getString("password");
			int role = rs.getInt("role");

			Employee emp = new Employee(employeeId, employeeName, username, phone, email, employeeStatus, departmentId,
					password, role);
			System.out.println(emp);
			closeConn();
			return emp;
		}
		closeConn();
		return null;
	}

	@Override
	public List<Employee> getEmployeesLikeName(String name) throws SQLException {
		// sql 语句
		String sql = "select * from employee where employeeName like ? or username like ?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setString(1, "%" + name + "%");
		ps.setString(2, "%" + name + "%");
		// 获取结果
		ResultSet rs = ps.executeQuery();
		ArrayList<Employee> list = new ArrayList<Employee>();
		while (rs.next()) {
			// 获取一条数据
			int employeeId = rs.getInt("employeeId");
			String employeeName = rs.getString("employeeName");
			String username = rs.getString("username");
			String phone = rs.getString("phone");
			String email = rs.getString("email");
			int employeeStatus = rs.getInt("employeeStatus");
			int departmentId = rs.getInt("departmentId");
			String password = rs.getString("password");
			int role = rs.getInt("role");

			Employee emp = new Employee(employeeId, employeeName, username, phone, email, employeeStatus, departmentId,
					password, role);
			System.out.println(emp);
			list.add(emp);
		}
		closeConn();
		return list;
	}
}
