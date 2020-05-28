package servlet;

import dao.EmpDAO;
import dao.EmpDAOJDBCImpl;

import entity.Emp;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.util.List;
import java.io.PrintWriter;
import java.io.IOException;

public class ListEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			EmpDAO dao = new EmpDAOJDBCImpl();
			List<Emp> emps = dao.findAllEmp();
			out.println("<table border='1' width='60%'>");
			out.println("<option align='center'>Ա����Ϣ��</option>");
			out.println("<tr><td>ID</td><td>����</td><td>нˮ</td><td>����</td><td>����</td></tr>");
			for (Emp e : emps) {
				out.println("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getSalary()
						+ "</td><td>" + e.getAge() + "</td><td><a href='del?id=" + e.getId()
						+ "'>ɾ��</a><a href='modifyEmp.html?id=" + e.getId() + "'>�޸�</a></td></tr>");
			}
			out.println("</table>");
			out.println("<a href='addEmp.html'>���Ա��</a>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("�Ժ�����");
		}
	}
}
