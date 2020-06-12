package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Department;
import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;

@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取分析后的请求资源路径
		String uri = request.getRequestURI();
		CharSequence action = uri.subSequence(uri.lastIndexOf("/"), uri.lastIndexOf(".department")); // 含头不含尾

		// 依据请求，调用不同的分支来处理请求
		try {
			if (action.equals("/list")) {
				DepartmentDAO dao = new DepartmentDAOImpl();
				List<Department> depts = dao.getAllDepartments();

				request.setAttribute("depts", depts);
				request.getRequestDispatcher("listDepartments.jsp").forward(request, response);
			} else if (action.equals("/add")) {
				int departmentId = Integer.parseInt(request.getParameter("departmentId"));
				String departmentName = request.getParameter("departmentName");
				DepartmentDAO dao = new DepartmentDAOImpl();
				Department dept = new Department(departmentId, departmentName);

				dao.addDepartment(dept);
				response.sendRedirect("list.department");
			} else if (action.equals("/del")) {
				int departmentId = Integer.parseInt(request.getParameter("departmentId"));
				DepartmentDAO dao = new DepartmentDAOImpl();

				dao.deleteDepartmentById(departmentId);
				response.sendRedirect("list.department");
			} else if (action.equals("/load")) {
				int departmentId = Integer.parseInt(request.getParameter("departmentId"));
				DepartmentDAO dao = new DepartmentDAOImpl();
				Department dept = dao.getDepartmentById(departmentId);

				request.setAttribute("dept", dept);
				request.getRequestDispatcher("loadDepartment.jsp").forward(request, response);
			} else if (action.equals("/set")) {
				int departmentId = Integer.parseInt(request.getParameter("departmentId"));
				String departmentName = request.getParameter("departmentName");
				DepartmentDAO dao = new DepartmentDAOImpl();
				Department dept = new Department(departmentId, departmentName);

				dao.updateDepartment(dept);
				response.sendRedirect("list.department");
			}
		} catch (NumberFormatException | SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
