package beans;

import java.time.LocalDate;

public class PaymentsBean {
	
	private int paymentId;
	private String bookingId;
	private LocalDate paymentDate;
	private double paymentAmount;
	private String paymentMenthod;
	private int promoId;
	
	public PaymentsBean() {
	}

	public PaymentsBean(int paymentId, String bookingId, LocalDate paymentDate, double paymentAmount,
			String paymentMenthod, int promoId) {
		super();
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.paymentMenthod = paymentMenthod;
		this.promoId = promoId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentMenthod() {
		return paymentMenthod;
	}

	public void setPaymentMenthod(String paymentMenthod) {
		this.paymentMenthod = paymentMenthod;
	}

	public int getPromoId() {
		return promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}
	
	

}
