package service;

import java.util.List;

import beans.BookingsBean;

public interface BookingsService {

	public void addBooking(BookingsBean booking);

	public List<BookingsBean> getAllBookings();

	public void removeBooking(String bookingId);

	public void updateBooking(BookingsBean updateBooking);

	public BookingsBean getBookingById(int bookingId);

	public void approveBooking(int bookingId);

	public List<BookingsBean> getAllBookingWithEmail(String email);

}
