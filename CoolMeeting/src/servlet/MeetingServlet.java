package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Meeting;
import dao.MeetingDAO;
import dao.MeetingDAOImpl;
import utils.TimeUtils;

@WebServlet("/MeetingServlet")
public class MeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取分析后的请求资源路径
		String uri = request.getRequestURI();
		CharSequence action = uri.subSequence(uri.lastIndexOf("/"), uri.lastIndexOf(".meeting")); // 含头不含尾

		// 依据请求，调用不同的分支来处理请求
		try {
			if (action.equals("/list")) {
				MeetingDAO dao = new MeetingDAOImpl();
				List<Meeting> meetings = dao.getAllMeetings();

				request.setAttribute("meetings", meetings);
				request.getRequestDispatcher("listMeetings.jsp").forward(request, response);
			} else if (action.equals("/add")) {
				int meetingId = Integer.parseInt(request.getParameter("meetingId"));
				String meetingName = request.getParameter("meetingName");
				int roomId = Integer.parseInt(request.getParameter("roomId"));
				int participantNumber = Integer.parseInt(request.getParameter("participantNumber"));
				Timestamp startTime = TimeUtils.toSqlTimestamp(request.getParameter("startTime"));
				Timestamp endTime = TimeUtils.toSqlTimestamp(request.getParameter("endTime"));
				Timestamp reservationTime = new Timestamp(System.currentTimeMillis()); // 获取当前本地时间
				Timestamp cancellationTime = null; // 默认会议取消时间为空
				String meetingDescription = request.getParameter("meetingDescription");
				int meetingStatus = 0; // 默认会议状态——未进行
				MeetingDAO dao = new MeetingDAOImpl();
				Meeting meeting = new Meeting(meetingId, meetingName, roomId, participantNumber, startTime, endTime,
						reservationTime, cancellationTime, meetingDescription, meetingStatus);

				dao.addMeeting(meeting);
				response.sendRedirect("list.meeting");
			} else if (action.equals("/del")) {
				int meetingId = Integer.parseInt(request.getParameter("meetingId"));
				MeetingDAO dao = new MeetingDAOImpl();

				dao.deleteMeetingById(meetingId);
				response.sendRedirect("list.meeting");
			} else if (action.equals("/load")) {
				int meetingId = Integer.parseInt(request.getParameter("meetingId"));
				MeetingDAO dao = new MeetingDAOImpl();
				Meeting meeting = dao.getMeetingById(meetingId);

				request.setAttribute("meeting", meeting);
				request.getRequestDispatcher("loadMeeting.jsp").forward(request, response);
			} else if (action.equals("/set")) {
				int meetingId = Integer.parseInt(request.getParameter("meetingId"));
				String meetingName = request.getParameter("meetingName");
				int roomId = Integer.parseInt(request.getParameter("roomId"));
				int participantNumber = Integer.parseInt(request.getParameter("participantNumber"));
				Timestamp startTime = TimeUtils.toSqlTimestamp(request.getParameter("startTime"));
				Timestamp endTime = TimeUtils.toSqlTimestamp(request.getParameter("endTime"));
				Timestamp reservationTime = TimeUtils.toSqlTimestamp(request.getParameter("reservationTime"));
				Timestamp cancellationTime = TimeUtils.toSqlTimestamp(request.getParameter("cancellationTime"));
				String meetingDescription = request.getParameter("meetingDescription");
				int meetingStatus = Integer.parseInt(request.getParameter("meetingStatus"));
				MeetingDAO dao = new MeetingDAOImpl();
				Meeting meeting = new Meeting(meetingId, meetingName, roomId, participantNumber, startTime, endTime,
						reservationTime, cancellationTime, meetingDescription, meetingStatus);

				dao.updateMeeting(meeting);
				response.sendRedirect("list.meeting");
			}
		} catch (NumberFormatException | SQLException | IOException | ServletException | ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
