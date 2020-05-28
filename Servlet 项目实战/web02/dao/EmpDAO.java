package dao;

import entity.Emp;

import java.util.List;
import java.sql.SQLException;

public interface EmpDAO {
	// 查询所有员工信息
	public List<Emp> findAllEmp() throws SQLException;

	// 添加员工信息
	public void saveEmp(Emp emp) throws SQLException;

	// 按 ID 删除员工信息
	public void delEmp(int id) throws SQLException;

	// 修改员工信息
	public void modifyEmp(Emp emp) throws SQLException;
}
