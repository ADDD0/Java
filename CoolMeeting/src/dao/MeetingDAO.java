package dao;

import java.sql.SQLException;
import java.util.List;

import bean.Meeting;

public interface MeetingDAO {
	// 获取所有会议
	public List<Meeting> getAllMeetings() throws SQLException;

	// 添加会议
	public void addMeeting(Meeting meeting) throws SQLException;

	// 删除会议
	void deleteMeetingById(int meetingId) throws SQLException;

	// 更改会议
	public void updateMeeting(Meeting meeting) throws SQLException;

	// 搜索会议
	public Meeting getMeetingById(int meetingId) throws SQLException;
}
