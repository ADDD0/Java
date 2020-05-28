package servlet;

import dao.EmpDAO;
import dao.EmpDAOJDBCImpl;

import entity.Emp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.SQLException;

public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. ����û��������������
		request.setCharacterEncoding("utf-8");
		// 2. ��ȡ�û����������
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 3. ���û���������ݷ�װ�� Emp ������
		try {
			Emp emp = new Emp(name, salary, age);
			EmpDAO dao = new EmpDAOJDBCImpl();
			dao.saveEmp(emp);
			// �ض��� list
			response.sendRedirect("list");
		} catch (SQLException e) {
			// ��¼��־
			e.printStackTrace();
			// �쳣�����Ժ�Ҫ�����쳣������
			// �����ϵͳ�쳣���������ݿ����ֹͣ�������жϵȣ���һ���������쳣���������޷��ָ��ģ�ֻ��֪ͨ�û��Ժ�����
			out.println("�Ժ�����");
			// �����Ӧ���쳣��һ����������ʹ�ó���ʱ��������һЩ����Ĳ�������������һ�������ڵ��˺ţ�Ӧ���쳣һ�㶼�ǿ��Իָ��ģ�ֻ��Ҫ��ʾ�û�������ȷ�Ĳ���
		}
	}
}
