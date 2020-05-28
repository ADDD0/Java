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
		// ��ȡ�������������Դ·��
		String uri = request.getRequestURI();
		CharSequence action = uri.subSequence(uri.lastIndexOf("/"), uri.lastIndexOf(".")); // ��ͷ����β

		boolean success = true;
		// �������󣬵��ò�ͬ�ķ�֧����������
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
					out.println("�û������������");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				out.println("�Ժ�����");
			}

		} else if (action.equals("/list")) {
			try {
				UserDAO dao = new UserDAOImpl();
				// ʹ�� dao ��ȡ����Ա����Ϣ
				List<User> users = dao.findAll();
				// ���� JSP��ʹ��ת����
				// 1. ������
				request.setAttribute("users", users);
				// 2. ��ȡת����
				RequestDispatcher rd = request.getRequestDispatcher("listUsers.jsp");
				// 3. ת��
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
				out.println("�Ժ�����");
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
				out.println("ϵͳ�쳣,�Ժ�����");
			}
		} else if (action.equals("/load")) {
			int id = Integer.parseInt(request.getParameter("id"));

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();

			try {
				// 1. ͨ�� id ���ҵ���Ա������Ϣ
				UserDAO dao = new UserDAOImpl();
				User user = dao.findById(id);

				request.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("loadUser.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				out.println("ϵͳ��æ,�Ժ�����!");
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
				out.println("ϵͳ��æ,�Ժ�����!");
			}
		}
	}
}
