import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.util.Arrays;
import java.io.PrintWriter;
import java.io.IOException;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�û���Ϣ
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] interests = request.getParameterValues("interest");
		// ����ڿ���̨
		System.out.println("�û���:" + username);
		System.out.println("����:" + password);
		System.out.println("����:" + email);
		System.out.println("�Ա�:" + gender);
		System.out.println("����:" + Arrays.toString(interests));
		// �����ҳ����
		response.setContentType("text/java; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(username);
		out.println(password);
		out.println(email);
		out.println(gender);
		out.println(Arrays.toString(interests));
	}
}
