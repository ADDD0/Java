package bean;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	private int employeeId; // 员工号
	private String employeeName; // 员工名
	private String username; // 用户名
	private String phone; // 手机
	private String email; // 邮箱
	private int employeeStatus; // 员工状态
	private int departmentId; // 部门号
	private String password; // 密码
	private int role; // 角色

	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, String username, String phone, String email,
			int employeeStatus, int departmentId, String password, int role) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.employeeStatus = employeeStatus;
		this.departmentId = departmentId;
		this.password = password;
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmployeeStatus() {
		return employeeStatus;
	}

	public void setStatus(int employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", username=" + username
				+ ", phone=" + phone + ", email=" + email + ", employeeStatus=" + employeeStatus + ", departmentId="
				+ departmentId + ", password=" + password + ", role=" + role + "]";
	}
}
