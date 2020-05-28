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
		// 读取用户信息
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] interests = request.getParameterValues("interest");
		// 输出在控制台
		System.out.println("用户名:" + username);
		System.out.println("密码:" + password);
		System.out.println("邮箱:" + email);
		System.out.println("性别:" + gender);
		System.out.println("爱好:" + Arrays.toString(interests));
		// 输出在页面中
		response.setContentType("text/java; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(username);
		out.println(password);
		out.println(email);
		out.println(gender);
		out.println(Arrays.toString(interests));
	}
}
