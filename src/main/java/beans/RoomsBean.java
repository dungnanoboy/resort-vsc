package beans;

public class RoomsBean {
	
	private int roomId;
	private RoomTypesBean roomType; // Thêm thuộc tính để lưu thông tin về loại phòng
	private String roomName;
	private boolean status;
	
	public RoomsBean() {
	}

	public RoomsBean(int roomId, RoomTypesBean roomType, String roomName, boolean status) {
        super();
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomName = roomName;
        this.status = status;
    }

	public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public RoomTypesBean getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypesBean roomType) {
        this.roomType = roomType;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
