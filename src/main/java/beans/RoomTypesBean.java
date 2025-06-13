package beans;

import java.util.ArrayList;
import java.util.List;

public class RoomTypesBean {
	
	private int typeId;
	private String typeName;
	private int conditionId;
	private double pricePerNight;
	private String abst;
	private String description;
	private int occupancy;
	private String roomImage;
	private int availableRooms;
	
	private List<RoomConditionsBean> roomconditions;
	
	public RoomTypesBean() {
		this.roomconditions = new ArrayList<>();
	}

	public RoomTypesBean(int typeId, String typeName, int conditionId, double pricePerNight, String abst,
			String description, int occupancy, String roomImage, List<RoomConditionsBean> roomconditions, int availableRooms) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.conditionId = conditionId;
		this.pricePerNight = pricePerNight;
		this.abst = abst;
		this.description = description;
		this.occupancy = occupancy;
		this.roomImage = roomImage;
		this.roomconditions = roomconditions != null ? roomconditions : new ArrayList<>();
		this.availableRooms = availableRooms;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getConditionId() {
		return conditionId;
	}

	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public String getAbst() {
		return abst;
	}

	public void setAbst(String abst) {
		this.abst = abst;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public String getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(String roomImage) {
		this.roomImage = roomImage;
	}

	public List<RoomConditionsBean> getRoomconditions() {
		return roomconditions;
	}

	public void setRoomconditions(List<RoomConditionsBean> roomconditions) {
		this.roomconditions = roomconditions;
	}

	public int getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(int availableRooms) {
		this.availableRooms = availableRooms;
	}
	
	
}
