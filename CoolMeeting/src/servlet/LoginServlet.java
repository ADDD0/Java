package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Department;
import bean.Employee;
import bean.Room;
import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dao.RoomDAO;
import dao.RoomDAOImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean success = true;
		HttpSession session = request.getSession();
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String password = request.getParameter("password");
		EmployeeDAO empDAO = new EmployeeDAOImpl();

		try {
			if (empDAO.login(employeeId, password) == success) {
				Employee emp = empDAO.getEmployeeById(employeeId);
				// 设置用户
				session.setAttribute("user", emp);
				// 设置部门
				DepartmentDAO deptDAO = new DepartmentDAOImpl();
				List<Department> depts = deptDAO.getAllDepartments();
				session.setAttribute("deptlist", depts);
				// 设置会议室
				RoomDAO roomDAO = new RoomDAOImpl();
				List<Room> rooms = roomDAO.getAllRooms();
				session.setAttribute("roomlist", rooms);
				// 页面跳转
				response.sendRedirect("index.jsp");
			} else {
				request.setAttribute("msg", "登陆失败");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
