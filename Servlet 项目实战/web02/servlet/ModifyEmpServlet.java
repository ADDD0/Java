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

public class ModifyEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 解决用户输入的中文问题
		request.setCharacterEncoding("utf-8");
		// 2. 获取用户输入的数据
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			Emp emp = new Emp(id, name, salary, age);
			EmpDAO dao = new EmpDAOJDBCImpl();
			dao.modifyEmp(emp);
			response.sendRedirect("list");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("稍后再试");
		}
	}
}
