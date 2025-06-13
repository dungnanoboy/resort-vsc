package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookingStateBean;
import service.BookingStateService;
import utility.DBUtil;

public class BookingStateServiceImpl implements BookingStateService{
	
	@Override
	public List<BookingStateBean> getAllBookingState() {
		List<BookingStateBean> states = new ArrayList<BookingStateBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from BookingState");

			rs = ps.executeQuery();

			while (rs.next()) {

				BookingStateBean state = new BookingStateBean();

				state.setStateId(rs.getInt(1));
				state.setStateName(rs.getString(2));

				states.add(state);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return states;
	}

}
