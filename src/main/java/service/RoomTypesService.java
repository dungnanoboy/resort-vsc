package service;

import java.util.List;

import beans.RoomTypesBean;

public interface RoomTypesService {

	public List<RoomTypesBean> getAllBasicRoom();

	public List<RoomTypesBean> getAllLuxuryRoom();

	public List<RoomTypesBean> getAllSpecialRoom();

	public List<RoomTypesBean> getAllRoomTypes();

	public RoomTypesBean getRoomTypeDetails(int roomtypeId);

}
