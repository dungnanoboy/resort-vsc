package beans;

import java.time.LocalDate;

public class BookingsBean {
	
	private int bookingId;
	private String email;
	private int roomId;
	private LocalDate  checkInDate;
	private LocalDate  checkOutDate;
	private double totalPrice;
	private boolean isPaid;
	private int stateId;
	
	public BookingsBean() {
	}

	// Constructor sử dụng bookingId
	public BookingsBean(int bookingId, String email, int roomId, LocalDate  checkInDate, LocalDate  checkOutDate,
			double totalPrice, boolean isPaid, int stateId) {
		super();
		this.bookingId = bookingId;
		this.email = email;
		this.roomId = roomId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.totalPrice = totalPrice;
		this.isPaid = isPaid;
		this.stateId = stateId;
	}
	
	// Constructor không sử dụng bookingId
	public BookingsBean(String email, int roomId, LocalDate  checkInDate, LocalDate  checkOutDate,
            double totalPrice, boolean isPaid, int stateId) {
        this.email = email;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.isPaid = isPaid;
        this.stateId = stateId;
    }

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public LocalDate  getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate  checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate  getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate  checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	

}
