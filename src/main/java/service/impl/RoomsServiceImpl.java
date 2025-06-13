package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.RoomTypesBean;
import beans.RoomsBean;
import utility.DBUtil;

import service.RoomsService;

public class RoomsServiceImpl implements RoomsService{
	
	@Override
	public List<RoomsBean> findAvailableRooms(String checkinDate, String checkoutDate, int occupancy, String roomType) {
        List<RoomsBean> availableRooms = new ArrayList<>();
        
        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT r.room_id, r.room_name, r.type_id, r.status, " +
                "       rt.type_id AS rt_type_id, rt.type_name, rt.condition_id, " +
                "       rt.price_per_night, rt.abst, rt.description, rt.occupancy, rt.room_image " +
                "FROM Rooms r " +
                "JOIN RoomTypes rt ON r.type_id = rt.type_id " +
                "WHERE r.status = TRUE " +
                "AND rt.type_name = ? " +
                "AND rt.occupancy >= ? " +
                "AND NOT EXISTS ( " +
                "    SELECT 1 " +
                "    FROM Bookings b " +
                "    WHERE r.room_id = b.room_id " +
                "    AND ? < b.check_out_date " +
                "    AND ? > b.check_in_date " +
                ")";

        try {

        	ps = con.prepareStatement(sql);
            ps.setString(1, roomType);
            ps.setInt(2, occupancy);
            ps.setString(3, checkinDate);
            ps.setString(4, checkoutDate);
            
         // Debug: In ra câu lệnh SQL và các tham số
            System.out.println("SQL: " + ps);
            
            
            rs = ps.executeQuery();
            
                while (rs.next()) {
                    RoomsBean room = new RoomsBean();
                    
                    room.setRoomId(rs.getInt("room_id"));
                    room.setRoomName(rs.getString("room_name"));
                    room.setStatus(rs.getBoolean("status"));
                    
                    // Lấy thông tin về loại phòng từ kết quả truy vấn
                    RoomTypesBean roomTypeBean = new RoomTypesBean();
                    roomTypeBean.setTypeId(rs.getInt("rt_type_id"));
                    roomTypeBean.setTypeName(rs.getString("type_name"));
                    roomTypeBean.setConditionId(rs.getInt("condition_id"));
                    roomTypeBean.setPricePerNight(rs.getDouble("price_per_night"));
                    roomTypeBean.setAbst(rs.getString("abst"));
                    roomTypeBean.setDescription(rs.getString("description"));
                    roomTypeBean.setOccupancy(rs.getInt("occupancy"));
                    roomTypeBean.setRoomImage(rs.getString("room_image"));
                    
                    // Đặt thông tin loại phòng vào phòng
                    room.setRoomType(roomTypeBean);
                    
                    availableRooms.add(room);
                }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(con);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(rs);
        }

        return availableRooms;
    }
	
	@Override
	public List<RoomsBean> getAllRooms() {
		List<RoomsBean> rooms = new ArrayList<RoomsBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT r.room_id, r.room_name, r.status, rt.type_id, rt.type_name, rt.condition_id, rt.price_per_night, rt.abst, rt.description, rt.occupancy, rt.room_image " +
		            "FROM Rooms r " +
		            "JOIN RoomTypes rt ON r.type_id = rt.type_id");

			rs = ps.executeQuery();

			while (rs.next()) {

				RoomsBean room = new RoomsBean();

	            room.setRoomId(rs.getInt("room_id"));
	            room.setRoomName(rs.getString("room_name"));
	            room.setStatus(rs.getBoolean("status"));
	            
	            RoomTypesBean roomTypeBean = new RoomTypesBean();
	            roomTypeBean.setTypeId(rs.getInt("type_id"));
	            roomTypeBean.setTypeName(rs.getString("type_name"));
	            roomTypeBean.setConditionId(rs.getInt("condition_id"));
	            roomTypeBean.setPricePerNight(rs.getDouble("price_per_night"));
	            roomTypeBean.setAbst(rs.getString("abst"));
	            roomTypeBean.setDescription(rs.getString("description"));
	            roomTypeBean.setOccupancy(rs.getInt("occupancy"));
	            roomTypeBean.setRoomImage(rs.getString("room_image"));
	            
	            room.setRoomType(roomTypeBean);

	            rooms.add(room);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return rooms;
	}

}
