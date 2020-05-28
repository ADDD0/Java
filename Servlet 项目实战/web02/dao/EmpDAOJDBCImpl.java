package dao;

import entity.Emp;

import utils.DBUtils;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAOJDBCImpl implements EmpDAO {
	public List<Emp> findAllEmp() throws SQLException {
		List<Emp> emps = new ArrayList<>();
		Connection conn = DBUtils.getConn();

		String sql = "select * from t_emp";
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Emp e = new Emp();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setSalary(rs.getDouble("salary"));
			e.setAge(rs.getInt("age"));
			emps.add(e);
		}
		DBUtils.close(conn);
		return emps;
	}

	public void saveEmp(Emp emp) throws SQLException {
		// 1. 获取数据库连接对象
		Connection conn = DBUtils.getConn();
		// 2. 创建 SQL 执行对象
		String sql = "insert into t_emp(name, salary, age) value(?, ?, ?)";
		PreparedStatement pstat = conn.prepareStatement(sql);
		// 3. 设置问号的数据
		pstat.setString(1, emp.getName());
		pstat.setDouble(2, emp.getSalary());
		pstat.setInt(3, emp.getAge());
		// 4. 执行 sql
		pstat.execute();
		// 5. 关闭连接
		DBUtils.close(conn);
	}

	public void delEmp(int id) throws SQLException {
		// 1. 获取数据库连接对象
		Connection conn = DBUtils.getConn();
		// 2. 创建 SQL 执行对象
		String sql = "delete from t_emp where id=?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		// 3. 设置问号的数据
		pstat.setInt(1, id);
		// 4. 执行 sql
		pstat.execute();
		// 5. 关闭连接
		DBUtils.close(conn);
	}

	public void modifyEmp(Emp emp) throws SQLException {
		// 1. 获取数据库连接对象
		Connection conn = DBUtils.getConn();
		// 2. 创建SQL执行对象
		String sql = "update t_emp set name=?, salary=?, age=? where id=?";
		PreparedStatement pstat = conn.prepareStatement(sql);
		// 3. 设置问号的数据
		pstat.setString(1, emp.getName());
		pstat.setDouble(2, emp.getSalary());
		pstat.setInt(3, emp.getAge());
		pstat.setInt(4, emp.getId());
		// 4. 执行 sql
		pstat.execute();
		// 5. 关闭连接
		DBUtils.close(conn);
	}
}
