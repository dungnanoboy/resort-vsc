package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.RoomConditionsBean;
import beans.RoomTypesBean;
import service.RoomTypesService;
import utility.DBUtil;

public class RoomTypesServiceImpl implements RoomTypesService{
	
	@Override
	public List<RoomTypesBean> getAllBasicRoom() {
	    List<RoomTypesBean> roomtypes = new ArrayList<>();

	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT rt.type_id, rt.type_name, rc.condition_id, rc.condition_name, rt.price_per_night, rt.abst, rt.description, rt.occupancy, rt.room_image, COUNT(r.room_id) AS available_rooms " +
	                "FROM RoomTypes rt " +
	                "JOIN RoomConditions rc ON rt.condition_id = rc.condition_id " +
	                "LEFT JOIN Rooms r ON rt.type_id = r.type_id AND r.status = TRUE " +
	                "WHERE rt.condition_id = 1 " +
	                "GROUP BY rt.type_id, rt.type_name, rc.condition_id, rc.condition_name, rt.price_per_night, rt.abst, rt.description, rt.occupancy, rt.room_image";

	        ps = con.prepareStatement(query);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	        	RoomTypesBean roomtype = new RoomTypesBean();

	            roomtype.setTypeId(rs.getInt("type_id"));
	            roomtype.setTypeName(rs.getString("type_name"));
	            roomtype.setConditionId(rs.getInt("condition_id"));
	            roomtype.setPricePerNight(rs.getDouble("price_per_night"));
	            roomtype.setAbst(rs.getString("abst"));
	            roomtype.setDescription(rs.getString("description"));
	            roomtype.setOccupancy(rs.getInt("occupancy"));
	            roomtype.setRoomImage(rs.getString("room_image"));
	            
	            RoomConditionsBean roomcondition = new RoomConditionsBean();
	            roomcondition.setConditionName(rs.getString("condition_name"));
	            roomtype.getRoomconditions().add(roomcondition);
	            
	            roomtype.setAvailableRooms(rs.getInt("available_rooms")); // Assuming you have a field availableRooms in RoomTypesBean to store this value.

	            roomtypes.add(roomtype);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	        DBUtil.closeConnection(rs);
	    }

	    return roomtypes;
	}
	
	@Override
	public List<RoomTypesBean> getAllLuxuryRoom() {
	    List<RoomTypesBean> roomtypes = new ArrayList<>();

	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT rt.type_id, rt.type_name, rc.condition_id, rc.condition_name, rt.price_per_night, rt.abst, rt.description, rt.occupancy, rt.room_image, COUNT(r.room_id) AS available_rooms " +
	                "FROM RoomTypes rt " +
	                "JOIN RoomConditions rc ON rt.condition_id = rc.condition_id " +
	                "LEFT JOIN Rooms r ON rt.type_id = r.type_id AND r.status = TRUE " +
	                "WHERE rt.condition_id = 2 " +
	                "GROUP BY rt.type_id, rt.type_name, rc.condition_id, rc.condition_name, rt.price_per_night, rt.abst, rt.description, rt.occupancy, rt.room_image";

	        ps = con.prepareStatement(query);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	        	RoomTypesBean roomtype = new RoomTypesBean();

	        	roomtype.setTypeId(rs.getInt("type_id"));
	        	roomtype.setTypeName(rs.getString("type_name"));
	        	roomtype.setConditionId(rs.getInt("condition_id"));
	        	roomtype.setPricePerNight(rs.getDouble("price_per_night"));
	        	roomtype.setAbst(rs.getString("abst"));
	        	roomtype.setDescription(rs.getString("description"));
	        	roomtype.setOccupancy(rs.getInt("occupancy"));
	        	roomtype.setRoomImage(rs.getString("room_image"));

	        	RoomConditionsBean roomcondition = new RoomConditionsBean();
	        	roomcondition.setConditionName(rs.getString("condition_name"));
	        	roomtype.getRoomconditions().add(roomcondition);
	        	
	        	roomtype.setAvailableRooms(rs.getInt("available_rooms"));

	            roomtypes.add(roomtype);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	        DBUtil.closeConnection(rs);
	    }

	    return roomtypes;
	}
	
	@Override
	public List<RoomTypesBean> getAllSpecialRoom() {
	    List<RoomTypesBean> roomtypes = new ArrayList<>();

	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        String query = "SELECT rt.type_id, rt.type_name, rc.condition_id, rc.condition_name, rt.price_per_night, rt.abst, rt.description, rt.occupancy, rt.room_image, COUNT(r.room_id) AS available_rooms " +
	                "FROM RoomTypes rt " +
	                "JOIN RoomConditions rc ON rt.condition_id = rc.condition_id " +
	                "LEFT JOIN Rooms r ON rt.type_id = r.type_id AND r.status = TRUE " +
	                "WHERE rt.condition_id = 3 " +
	                "GROUP BY rt.type_id, rt.type_name, rc.condition_id, rc.condition_name, rt.price_per_night, rt.abst, rt.description, rt.occupancy, rt.room_image";

	        ps = con.prepareStatement(query);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	        	RoomTypesBean roomtype = new RoomTypesBean();

	        	roomtype.setTypeId(rs.getInt("type_id"));
	        	roomtype.setTypeName(rs.getString("type_name"));
	        	roomtype.setConditionId(rs.getInt("condition_id"));
	        	roomtype.setPricePerNight(rs.getDouble("price_per_night"));
	        	roomtype.setAbst(rs.getString("abst"));
	        	roomtype.setDescription(rs.getString("description"));
	        	roomtype.setOccupancy(rs.getInt("occupancy"));
	        	roomtype.setRoomImage(rs.getString("room_image"));

	        	RoomConditionsBean roomcondition = new RoomConditionsBean();
	        	roomcondition.setConditionName(rs.getString("condition_name"));
	        	roomtype.getRoomconditions().add(roomcondition);
	        	
	        	roomtype.setAvailableRooms(rs.getInt("available_rooms"));

	            roomtypes.add(roomtype);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	        DBUtil.closeConnection(rs);
	    }

	    return roomtypes;
	}
	
	@Override
	public List<RoomTypesBean> getAllRoomTypes() {
		List<RoomTypesBean> roomtypes = new ArrayList<RoomTypesBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from RoomTypes");

			rs = ps.executeQuery();

			while (rs.next()) {

				RoomTypesBean roomtype = new RoomTypesBean();

				roomtype.setTypeId(rs.getInt(1));
				roomtype.setTypeName(rs.getString(2));
				roomtype.setConditionId(rs.getInt(3));
				roomtype.setPricePerNight(rs.getDouble(4));
				roomtype.setAbst(rs.getString(5));	
				roomtype.setDescription(rs.getString(6));
				roomtype.setOccupancy(rs.getInt(7));
				roomtype.setRoomImage(rs.getString(8));

				roomtypes.add(roomtype);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return roomtypes;
	}
	
	@Override
	public RoomTypesBean getRoomTypeDetails(int roomtypeId) {
		RoomTypesBean roomtype = null;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT rt.type_id, rt.type_name, rc.condition_id, rc.condition_name, rt.price_per_night, rt.abst, rt.description, rt.occupancy, rt.room_image " +
                    "FROM RoomTypes rt " +
                    "JOIN RoomConditions rc ON rt.condition_id = rc.condition_id " +
                    "WHERE rt.type_id = ?");

			ps.setInt(1, roomtypeId);
			rs = ps.executeQuery();

			if (rs.next()) {
				roomtype = new RoomTypesBean();
	            roomtype.setTypeId(rs.getInt("type_id"));
	            roomtype.setTypeName(rs.getString("type_name"));
	            roomtype.setConditionId(rs.getInt("condition_id"));
	            roomtype.setPricePerNight(rs.getDouble("price_per_night"));
	            roomtype.setAbst(rs.getString("abst"));
	            roomtype.setDescription(rs.getString("description"));
	            roomtype.setOccupancy(rs.getInt("occupancy"));
	            roomtype.setRoomImage(rs.getString("room_image"));

	            RoomConditionsBean roomcondition = new RoomConditionsBean();
	            roomcondition.setConditionId(rs.getInt("condition_id"));
	            roomcondition.setConditionName(rs.getString("condition_name"));
	            roomtype.getRoomconditions().add(roomcondition);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);

		return roomtype;
	}

}
