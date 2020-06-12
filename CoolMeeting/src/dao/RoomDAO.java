package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Room;

public interface RoomDAO {
	// 获取所有会议室
	public List<Room> getAllRooms() throws SQLException;

	// 添加会议室
	public void addRoom(Room room) throws SQLException;

	// 删除会议室
	void deleteRoomById(int roomId) throws SQLException;

	// 更改会议室
	public void updateRoom(Room room) throws SQLException;

	// 搜索会议室
	public Room getRoomById(int roomId) throws SQLException;
}
