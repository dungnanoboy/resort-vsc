package service;

import java.util.List;

import beans.RoomsBean;

public interface RoomsService {

	public List<RoomsBean> findAvailableRooms(String checkinDate, String checkoutDate, int occupancy, String roomType);

	public List<RoomsBean> getAllRooms();

}
