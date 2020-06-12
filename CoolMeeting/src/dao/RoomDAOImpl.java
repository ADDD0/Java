package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Room;

public class RoomDAOImpl extends BaseDAO implements RoomDAO {
	@Override
	public List<Room> getAllRooms() throws SQLException {
		// sql 语句
		String sql = "select * from room";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// 获取结果
		ResultSet rs = ps.executeQuery();
		ArrayList<Room> list = new ArrayList<Room>();
		while (rs.next()) {
			// 获取一条数据
			int roomId = rs.getInt("roomId");
			int roomNumber = rs.getInt("roomNumber");
			String roomName = rs.getString("roomName");
			int capacity = rs.getInt("capacity");
			int roomStatus = rs.getInt("roomStatus");
			String roomDescription = rs.getString("roomDescription");

			Room room = new Room(roomId, roomNumber, roomName, capacity, roomStatus, roomDescription);
			System.out.println(room);
			list.add(room);
		}
		closeConn();
		return list;
	}

	@Override
	public void addRoom(Room room) throws SQLException {
		// sql 语句
		String sql = "insert into room values(?,?,?,?,?,?)";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, room.getRoomId());
		ps.setInt(2, room.getRoomNumber());
		ps.setString(3, room.getRoomName());
		ps.setInt(4, room.getCapacity());
		ps.setInt(5, room.getRoomStatus());
		ps.setString(6, room.getRoomDescription());
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public void deleteRoomById(int roomId) throws SQLException {
		// sql 语句
		String sql = "delete from room where roomId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, roomId);
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public void updateRoom(Room room) throws SQLException {
		// sql 语句
		String sql = "update room set roomNumber=?,roomName=?,capacity=?,roomStatus=?,roomDescription=? where roomId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, room.getRoomNumber());
		ps.setString(2, room.getRoomName());
		ps.setInt(3, room.getCapacity());
		ps.setInt(4, room.getRoomStatus());
		ps.setString(5, room.getRoomDescription());
		ps.setInt(6, room.getRoomId());
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public Room getRoomById(int roomId) throws SQLException {
		// sql 语句
		String sql = "select * from room where roomId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, roomId);
		// 获取结果
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// 获取一条数据
			int roomNumber = rs.getInt("roomNumber");
			String roomName = rs.getString("roomName");
			int capacity = rs.getInt("capacity");
			int roomStatus = rs.getInt("roomStatus");
			String roomDescription = rs.getString("roomDescription");

			Room room = new Room(roomId, roomNumber, roomName, capacity, roomStatus, roomDescription);
			System.out.println(room);
			closeConn();
			return room;
		}
		closeConn();
		return null;
	}
}
