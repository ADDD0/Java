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
		// step1: ��ȡ�������
		String heightStr = request.getParameter("height");
		String weightStr = request.getParameter("weight");
		String genderStr = request.getParameter("gender");
		// step2: ��������
		Double bmi = Double.parseDouble(weightStr) / Double.parseDouble(heightStr) / Double.parseDouble(heightStr);
		String status = "";
		if ("m".equals(genderStr)) {
			if (bmi < 20)
				status = "����";
			else if (bmi < 25)
				status = "����";
			else if (bmi < 30)
				status = "����";
			else if (bmi < 35)
				status = "����";
			else
				status = "�ǳ�����";
		} else if ("f".equals(genderStr)) {
			if (bmi < 19)
				status = "����";
			else if (bmi < 24)
				status = "����";
			else if (bmi < 29)
				status = "����";
			else if (bmi < 34)
				status = "����";
			else
				status = "�ǳ�����";
		}
		// step3: ���������
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("���bmiָ����:" + bmi + "��������״����:" + status);
	}
}
