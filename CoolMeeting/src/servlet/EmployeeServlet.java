package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取分析后的请求资源路径
		String uri = request.getRequestURI();
		CharSequence action = uri.subSequence(uri.lastIndexOf("/"), uri.lastIndexOf(".employee")); // 含头不含尾

		// 依据请求，调用不同的分支来处理请求
		try {
			if (action.equals("/list")) {
				EmployeeDAO dao = new EmployeeDAOImpl();
				List<Employee> emps = dao.getAllEmployees();

				request.setAttribute("emps", emps);
				request.getRequestDispatcher("listEmployees.jsp").forward(request, response);
			} else if (action.equals("/add")) {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				String employeeName = request.getParameter("employeeName");
				String username = request.getParameter("username");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				int employeeStatus = 1; // 默认状态——已审核
				int departmentId = Integer.parseInt(request.getParameter("departmentId"));
				String password = request.getParameter("password");
				int role = 1; // 默认角色——管理员
				EmployeeDAO dao = new EmployeeDAOImpl();
				Employee emp = new Employee(employeeId, employeeName, username, phone, email, employeeStatus,
						departmentId, password, role);

				dao.addEmployee(emp);
				response.sendRedirect("list.employee");
			} else if (action.equals("/del")) {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				EmployeeDAO dao = new EmployeeDAOImpl();

				dao.deleteEmployeeById(employeeId);
				response.sendRedirect("list.employee");
			} else if (action.equals("/load")) {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				EmployeeDAO dao = new EmployeeDAOImpl();
				Employee emp = dao.getEmployeeById(employeeId);

				request.setAttribute("emp", emp);
				request.getRequestDispatcher("loadEmployee.jsp").forward(request, response);
			} else if (action.equals("/set")) {
				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
				String employeeName = request.getParameter("employeeName");
				String username = request.getParameter("username");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				int employeeStatus = Integer.parseInt(request.getParameter("employeeStatus"));
				int departmentId = Integer.parseInt(request.getParameter("departmentId"));
				String password = request.getParameter("password");
				int role = Integer.parseInt(request.getParameter("role"));
				EmployeeDAO dao = new EmployeeDAOImpl();
				Employee emp = new Employee(employeeId, employeeName, username, phone, email, employeeStatus,
						departmentId, password, role);

				dao.updateEmployee(emp);
				response.sendRedirect("list.employee");
			} else if (action.equals("/query")) {
				// 姓名模糊查询
				String name = request.getParameter("queryName");
				EmployeeDAO dao = new EmployeeDAOImpl();
				List<Employee> emps = dao.getEmployeesLikeName(name);

				request.setAttribute("emps", emps);
				request.getRequestDispatcher("listEmployees.jsp").forward(request, response);
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
