package dao;

import entity.Emp;

import java.util.List;
import java.sql.SQLException;

public interface EmpDAO {
	// ��ѯ����Ա����Ϣ
	public List<Emp> findAllEmp() throws SQLException;

	// ���Ա����Ϣ
	public void saveEmp(Emp emp) throws SQLException;

	// �� ID ɾ��Ա����Ϣ
	public void delEmp(int id) throws SQLException;

	// �޸�Ա����Ϣ
	public void modifyEmp(Emp emp) throws SQLException;
}
