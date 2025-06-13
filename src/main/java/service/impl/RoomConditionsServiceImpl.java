package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.RoomConditionsBean;
import service.RoomConditionsService;
import utility.DBUtil;

public class RoomConditionsServiceImpl implements RoomConditionsService{
	
	@Override
	public List<RoomConditionsBean> getAllRoomConditions() {
		List<RoomConditionsBean> roomconditions = new ArrayList<RoomConditionsBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from RoomConditions");

			rs = ps.executeQuery();

			while (rs.next()) {

				RoomConditionsBean roomcondition = new RoomConditionsBean();

				roomcondition.setConditionId(rs.getInt(1));
				roomcondition.setConditionName(rs.getString(2));
				
				roomconditions.add(roomcondition);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return roomconditions;
	}

}
