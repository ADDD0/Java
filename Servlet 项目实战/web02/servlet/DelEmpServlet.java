package servlet;

import dao.EmpDAO;
import dao.EmpDAOJDBCImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.SQLException;

public class DelEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 解决用户输入的中文问题
		request.setCharacterEncoding("utf-8");
		// 2. 获取要删除的 ID
		int id = Integer.parseInt(request.getParameter("id"));

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		EmpDAO dao = new EmpDAOJDBCImpl();
		try {
			dao.delEmp(id);
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("稍后再试");
		}
		// 重定向到 list
		response.sendRedirect("list");
	}
}
