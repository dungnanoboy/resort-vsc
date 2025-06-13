package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookingsBean;
import service.BookingsService;
import utility.DBUtil;

public class BookingsServiceImpl implements BookingsService{
	
	@Override
	public void addBooking(BookingsBean booking) {


		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("INSERT INTO bookings (email, room_id, check_in_date, check_out_date, total_price, is_paid, state_id) VALUES (?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, booking.getEmail());
            ps.setInt(2, booking.getRoomId());
            ps.setDate(3, java.sql.Date.valueOf(booking.getCheckInDate()));
            ps.setDate(4, java.sql.Date.valueOf(booking.getCheckOutDate()));
            ps.setDouble(5, booking.getTotalPrice());
            ps.setBoolean(6, booking.isPaid());
            ps.setInt(7, booking.getStateId());
			
			ps.executeUpdate();


		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	    }
	}
	
	@Override
	public void removeBooking(String bookingId) {

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("delete from bookings where booking_id=?");
	        ps.setString(1, bookingId);

	        ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);

	}
	
	@Override
	public void updateBooking(BookingsBean updateBooking) {
		Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;

	    try {
	        ps = con.prepareStatement("update Bookings set email=?,room_id=?,check_in_date=?, check_out_date=?, total_price=?, is_paid=?, state_id=? where booking_id=?");

	        ps.setString(1, updateBooking.getEmail());
	        ps.setInt(2, updateBooking.getRoomId());
	        ps.setDate(3, java.sql.Date.valueOf(updateBooking.getCheckInDate()));
	        ps.setDate(4, java.sql.Date.valueOf(updateBooking.getCheckOutDate()));
	        ps.setDouble(5, updateBooking.getTotalPrice());
            ps.setBoolean(6, updateBooking.isPaid());
            ps.setInt(7, updateBooking.getStateId());
            ps.setInt(8, updateBooking.getBookingId());
	        
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	    }
	}
	
	@Override
	public BookingsBean getBookingById(int bookingId) {
		BookingsBean booking = null;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from bookings where booking_id=?");

			ps.setInt(1, bookingId);
			rs = ps.executeQuery();

			if (rs.next()) {
				booking = new BookingsBean();
				booking.setBookingId(rs.getInt("booking_id"));
				booking.setEmail(rs.getString("email"));
				booking.setRoomId(rs.getInt("room_id"));
				booking.setCheckInDate(rs.getDate("check_in_date").toLocalDate());
				booking.setCheckOutDate(rs.getDate("check_out_date").toLocalDate());
				booking.setTotalPrice(rs.getDouble("total_price"));
				booking.setPaid(rs.getBoolean("is_paid"));
				booking.setStateId(rs.getInt("state_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);

		return booking;
	}
	
	
	@Override
	public List<BookingsBean> getAllBookings() {
		List<BookingsBean> bookings = new ArrayList<BookingsBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from bookings");

			rs = ps.executeQuery();

			while (rs.next()) {

				BookingsBean book = new BookingsBean();

				book.setBookingId(rs.getInt(1));
				book.setEmail(rs.getString(2));
				book.setRoomId(rs.getInt(3));
				book.setCheckInDate(rs.getDate(4).toLocalDate());
				book.setCheckOutDate(rs.getDate(5).toLocalDate());
				book.setTotalPrice(rs.getDouble(6));
				book.setPaid(rs.getBoolean(7));
				book.setStateId(rs.getInt(8));

				bookings.add(book);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return bookings;
	}
	
	@Override
	public void approveBooking(int bookingId) {
	    Connection con = DBUtil.provideConnection();
	    PreparedStatement ps = null;

	    try {
	        ps = con.prepareStatement("UPDATE Bookings SET state_id = 2 WHERE booking_id = ?");
	        ps.setInt(1, bookingId);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	    }
	}
	
	@Override
	public List<BookingsBean> getAllBookingWithEmail(String email) {
        List<BookingsBean> bookings = new ArrayList<>();
        
        Connection con = DBUtil.provideConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT b.booking_id, b.email, b.room_id, b.check_in_date, b.check_out_date, b.total_price, b.state_id, b.is_paid " +
                       "FROM Bookings b ";

        if (email != null && !email.isEmpty()) {
            query += "WHERE b.email = ?";
        }

        try {
            ps = con.prepareStatement(query);

            if (email != null && !email.isEmpty()) {
                ps.setString(1, email);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                BookingsBean booking = new BookingsBean();
                booking.setBookingId(rs.getInt("booking_id"));
                booking.setEmail(rs.getString("email"));
                booking.setRoomId(rs.getInt("room_id"));
                booking.setCheckInDate(rs.getDate("check_in_date").toLocalDate());
                booking.setCheckOutDate(rs.getDate("check_out_date").toLocalDate());
                booking.setTotalPrice(rs.getDouble("total_price"));
                booking.setStateId(rs.getInt("state_id"));
                booking.setPaid(rs.getBoolean("is_paid"));

                bookings.add(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(con);
            DBUtil.closeConnection(ps);
            DBUtil.closeConnection(rs);
        }

        return bookings;
    }

}
