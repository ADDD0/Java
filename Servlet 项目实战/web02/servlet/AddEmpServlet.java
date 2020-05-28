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
		// 1. 解决用户输入的中文问题
		request.setCharacterEncoding("utf-8");
		// 2. 获取用户输入的数据
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// 3. 把用户输入的数据封装到 Emp 对象中
		try {
			Emp emp = new Emp(name, salary, age);
			EmpDAO dao = new EmpDAOJDBCImpl();
			dao.saveEmp(emp);
			// 重定向到 list
			response.sendRedirect("list");
		} catch (SQLException e) {
			// 记录日志
			e.printStackTrace();
			// 异常发生以后，要区分异常的类型
			// 如果是系统异常（比如数据库服务停止、网络中断等），一般这样的异常，程序是无法恢复的，只能通知用户稍后再试
			out.println("稍后再试");
			// 如果是应用异常（一般是由于在使用程序时，进行了一些错误的操作，比如输入一个不存在的账号，应用异常一般都是可以恢复的）只需要提示用户进行正确的操作
		}
	}
}
