package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bean.Meeting;

public class MeetingDAOImpl extends BaseDAO implements MeetingDAO {
	@Override
	public List<Meeting> getAllMeetings() throws SQLException {
		// sql 语句
		String sql = "select * from meeting";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// 获取结果
		ResultSet rs = ps.executeQuery();
		ArrayList<Meeting> list = new ArrayList<Meeting>();
		while (rs.next()) {
			// 获取一条数据
			int meetingId = rs.getInt("meetingId");
			String meetingName = rs.getString("meetingName");
			int roomId = rs.getInt("roomId");
			int participantNumber = rs.getInt("participantNumber");
			Timestamp startTime = rs.getTimestamp("startTime");
			Timestamp endTime = rs.getTimestamp("endTime");
			Timestamp reservationTime = rs.getTimestamp("reservationTime");
			Timestamp cancellationTime = rs.getTimestamp("cancellationTime");
			String meetingDescription = rs.getString("meetingDescription");
			int meetingStatus = rs.getInt("meetingStatus");

			Meeting meeting = new Meeting(meetingId, meetingName, roomId, participantNumber, startTime, endTime,
					reservationTime, cancellationTime, meetingDescription, meetingStatus);
			System.out.println(meeting);
			list.add(meeting);
		}
		closeConn();
		return list;
	}

	@Override
	public void addMeeting(Meeting meeting) throws SQLException {
		// sql 语句
		String sql = "insert into meeting values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, meeting.getMeetingId());
		ps.setString(2, meeting.getMeetingName());
		ps.setInt(3, meeting.getRoomId());
		ps.setInt(4, meeting.getParticipantNumber());
		ps.setTimestamp(5, meeting.getStartTime());
		ps.setTimestamp(6, meeting.getEndTime());
		ps.setTimestamp(7, meeting.getReservationTime());
		ps.setTimestamp(8, meeting.getCancellationTime());
		ps.setString(9, meeting.getMeetingDescription());
		ps.setInt(10, meeting.getMeetingStatus());
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public void deleteMeetingById(int meetingId) throws SQLException {
		// sql 语句
		String sql = "delete from meeting where meetingId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, meetingId);
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public void updateMeeting(Meeting meeting) throws SQLException {
		// sql 语句
		String sql = "update meeting set meetingName=?,roomId=?,participantNumber=?,startTime=?,endTime=?,reservationTime=?,cancellationTime=?,meetingDescription=?,meetingStatus=? where meetingId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setString(1, meeting.getMeetingName());
		ps.setInt(2, meeting.getRoomId());
		ps.setInt(3, meeting.getParticipantNumber());
		ps.setTimestamp(4, meeting.getStartTime());
		ps.setTimestamp(5, meeting.getEndTime());
		ps.setTimestamp(6, meeting.getReservationTime());
		ps.setTimestamp(7, meeting.getCancellationTime());
		ps.setString(8, meeting.getMeetingDescription());
		ps.setInt(9, meeting.getMeetingStatus());
		ps.setInt(10, meeting.getMeetingId());
		// 执行语句
		ps.executeUpdate();
		closeConn();
	}

	@Override
	public Meeting getMeetingById(int meetingId) throws SQLException {
		// sql 语句
		String sql = "select * from meeting where meetingId=?";
		PreparedStatement ps = getConn().prepareStatement(sql);
		// ? 替换
		ps.setInt(1, meetingId);
		// 获取结果
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// 获取一条数据
			String meetingName = rs.getString("meetingName");
			int roomId = rs.getInt("roomId");
			int participantNumber = rs.getInt("participantNumber");
			Timestamp startTime = rs.getTimestamp("startTime");
			Timestamp endTime = rs.getTimestamp("endTime");
			Timestamp reservationTime = rs.getTimestamp("reservationTime");
			Timestamp cancellationTime = rs.getTimestamp("cancellationTime");
			String meetingDescription = rs.getString("meetingDescription");
			int meetingStatus = rs.getInt("meetingStatus");

			Meeting meeting = new Meeting(meetingId, meetingName, roomId, participantNumber, startTime, endTime,
					reservationTime, cancellationTime, meetingDescription, meetingStatus);
			System.out.println(meeting);
			closeConn();
			return meeting;
		}
		closeConn();
		return null;
	}
}
