package bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Meeting implements Serializable {
	private static final long serialVersionUID = 1L;

	private int meetingId; // 会议号
	private String meetingName; // 会议名
	private int roomId; // 会议室号
	private int participantNumber; // 与会人数
	private Timestamp startTime; // 开始时间
	private Timestamp endTime; // 结束时间
	private Timestamp reservationTime; // 预定时间
	private Timestamp cancellationTime; // 取消时间
	private String meetingDescription; // 会议描述
	private int meetingStatus; // 会议状态

	public Meeting() {
		super();
	}

	public Meeting(int meetingId, String meetingName, int roomId, int participantNumber, Timestamp startTime,
			Timestamp endTime, Timestamp reservationTime, Timestamp cancellationTime, String meetingDescription,
			int meetingStatus) {
		super();
		this.meetingId = meetingId;
		this.meetingName = meetingName;
		this.roomId = roomId;
		this.participantNumber = participantNumber;
		this.startTime = startTime;
		this.endTime = endTime;
		this.reservationTime = reservationTime;
		this.cancellationTime = cancellationTime;
		this.meetingDescription = meetingDescription;
		this.meetingStatus = meetingStatus;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingName() {
		return meetingName;
	}

	public void setMeetingName(String meetingName) {
		this.meetingName = meetingName;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getParticipantNumber() {
		return participantNumber;
	}

	public void setParticipantNumber(int participantNumber) {
		this.participantNumber = participantNumber;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Timestamp reservationTime) {
		this.reservationTime = reservationTime;
	}

	public Timestamp getCancellationTime() {
		return cancellationTime;
	}

	public void setCancellationTime(Timestamp cancellationTime) {
		this.cancellationTime = cancellationTime;
	}

	public String getMeetingDescription() {
		return meetingDescription;
	}

	public void setMeetingDescription(String meetingDescription) {
		this.meetingDescription = meetingDescription;
	}

	public int getMeetingStatus() {
		return meetingStatus;
	}

	public void setMeetingStatus(int meetingStatus) {
		this.meetingStatus = meetingStatus;
	}

	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", meetingName=" + meetingName + ", roomId=" + roomId
				+ ", participantNumber=" + participantNumber + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", reservationTime=" + reservationTime + ", cancellationTime=" + cancellationTime
				+ ", meetingDescription=" + meetingDescription + ", meetingStatus=" + meetingStatus + "]";
	}

}
