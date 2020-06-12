package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Room;
import dao.RoomDAO;
import dao.RoomDAOImpl;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取分析后的请求资源路径
		String uri = request.getRequestURI();
		CharSequence action = uri.subSequence(uri.lastIndexOf("/"), uri.lastIndexOf(".room")); // 含头不含尾

		// 依据请求，调用不同的分支来处理请求
		try {
			if (action.equals("/list")) {
				RoomDAO dao = new RoomDAOImpl();
				List<Room> rooms = dao.getAllRooms();

				request.setAttribute("rooms", rooms);
				request.getRequestDispatcher("listRooms.jsp").forward(request, response);
			} else if (action.equals("/add")) {
				int roomId = Integer.parseInt(request.getParameter("roomId"));
				int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
				String roomName = request.getParameter("roomName");
				int capacity = Integer.parseInt(request.getParameter("capacity"));
				int roomStatus = 0; // 默认状态——空闲
				String roomDescription = request.getParameter("roomDescription");
				RoomDAO dao = new RoomDAOImpl();
				Room room = new Room(roomId, roomNumber, roomName, capacity, roomStatus, roomDescription);

				dao.addRoom(room);
				response.sendRedirect("list.room");
			} else if (action.equals("/del")) {
				int roomId = Integer.parseInt(request.getParameter("roomId"));
				RoomDAO dao = new RoomDAOImpl();

				dao.deleteRoomById(roomId);
				response.sendRedirect("list.room");
			} else if (action.equals("/load")) {
				int roomId = Integer.parseInt(request.getParameter("roomId"));
				RoomDAO dao = new RoomDAOImpl();
				Room room = dao.getRoomById(roomId);

				request.setAttribute("room", room);
				request.getRequestDispatcher("loadRoom.jsp").forward(request, response);
			} else if (action.equals("/set")) {
				int roomId = Integer.parseInt(request.getParameter("roomId"));
				int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
				String roomName = request.getParameter("roomName");
				int capacity = Integer.parseInt(request.getParameter("capacity"));
				int roomStatus = Integer.parseInt(request.getParameter("roomStatus"));
				String roomDescription = request.getParameter("roomDescription");
				RoomDAO dao = new RoomDAOImpl();
				Room room = new Room(roomId, roomNumber, roomName, capacity, roomStatus, roomDescription);

				dao.updateRoom(room);
				response.sendRedirect("list.room");
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
