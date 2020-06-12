package bean;

import java.io.Serializable;

public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	private int roomId; // 会议室号
	private int roomNumber; // 会议房间号
	private String roomName; // 会议室名
	private int capacity; // 会议室容量
	private int roomStatus; // 会议室状态
	private String roomDescription; // 会议室描述

	public Room() {
		super();
	}

	public Room(int roomId, int roomNumber, String roomName, int capacity, int roomStatus, String roomDescription) {
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.capacity = capacity;
		this.roomStatus = roomStatus;
		this.roomDescription = roomDescription;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(int roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", roomName=" + roomName + ", capacity="
				+ capacity + ", roomStatus=" + roomStatus + ", roomDescription=" + roomDescription + "]";
	}
}
