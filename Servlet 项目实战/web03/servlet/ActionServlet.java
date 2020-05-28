package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取分析后的请求资源路径
		String uri = request.getRequestURI();
		CharSequence action = uri.subSequence(uri.lastIndexOf("/"), uri.lastIndexOf(".")); // 含头不含尾

		boolean success = true;
		// 依据请求，调用不同的分支来处理请求
		if (action.equals("/login")) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");

			try {
				UserDAO dao = new UserDAOImpl();
				boolean specify = dao.specify(username, pwd);
				if (specify == success) {
					response.sendRedirect("list.do");
				} else {
					out.println("用户名或密码错误");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				out.println("稍后再试");
			}

		} else if (action.equals("/list")) {
			try {
				UserDAO dao = new UserDAOImpl();
				// 使用 dao 获取所有员工信息
				List<User> users = dao.findAll();
				// 调用 JSP（使用转发）
				// 1. 绑定数据
				request.setAttribute("users", users);
				// 2. 获取转发器
				RequestDispatcher rd = request.getRequestDispatcher("listUsers.jsp");
				// 3. 转发
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (action.equals("/add")) {
			String username = request.getParameter("username");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			try {
				User user = new User(username, pwd, email);
				UserDAO dao = new UserDAOImpl();
				dao.addUser(user);
				response.sendRedirect("list.do");
			} catch (SQLException e) {
				e.printStackTrace();
				out.println("稍后再试");
			}
		} else if (action.equals("/del")) {
			int id = Integer.parseInt(request.getParameter("id"));

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			try {
				UserDAO dao = new UserDAOImpl();
				dao.delUser(id);
				response.sendRedirect("list.do");
			} catch (SQLException e) {
				e.printStackTrace();
				out.println("系统异常,稍后再试");
			}
		} else if (action.equals("/load")) {
			int id = Integer.parseInt(request.getParameter("id"));

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			try {
				// 1. 通过 id 查找到该员工的信息
				UserDAO dao = new UserDAOImpl();
				User user = dao.findById(id);

				request.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("loadUser.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				out.println("系统繁忙,稍后再试!");
			}

		} else if (action.equals("/modify")) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			try {
				UserDAO dao = new UserDAOImpl();

				int id = Integer.parseInt(request.getParameter("id"));
				String username = request.getParameter("username");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");

				User user = new User(id, username, pwd, email);
				dao.modifyUser(user);
				response.sendRedirect("list.do");
			} catch (SQLException e) {
				e.printStackTrace();
				out.println("系统繁忙,稍后再试!");
			}
		}
	}
}
