package db.vo;

public class Room {
	private int roomNo;
	private int roomCount;

	public Room() {}

	public Room(int roomNo, int roomCount) {
		super();
		this.roomNo = roomNo;
		this.roomCount = roomCount;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Room [roomNo=");
		builder.append(roomNo);
		builder.append(", roomCount=");
		builder.append(roomCount);
		builder.append("]");
		return builder.toString();
	}

}
