import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

public class BMIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// step1: 获取请求参数
		String heightStr = request.getParameter("height");
		String weightStr = request.getParameter("weight");
		String genderStr = request.getParameter("gender");
		// step2: 处理请求
		Double bmi = Double.parseDouble(weightStr) / Double.parseDouble(heightStr) / Double.parseDouble(heightStr);
		String status = "";
		if ("m".equals(genderStr)) {
			if (bmi < 20)
				status = "过轻";
			else if (bmi < 25)
				status = "正常";
			else if (bmi < 30)
				status = "过重";
			else if (bmi < 35)
				status = "肥胖";
			else
				status = "非常肥胖";
		} else if ("f".equals(genderStr)) {
			if (bmi < 19)
				status = "过轻";
			else if (bmi < 24)
				status = "正常";
			else if (bmi < 29)
				status = "过重";
			else if (bmi < 34)
				status = "肥胖";
			else
				status = "非常肥胖";
		}
		// step3: 输出处理结果
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("你的bmi指数是:" + bmi + "您的身体状况是:" + status);
	}
}
