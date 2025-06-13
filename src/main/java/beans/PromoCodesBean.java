package beans;

import java.time.LocalDate;

public class PromoCodesBean {
	
	private int promoId;
	private String promoCode;
	private double discountPercent;
	private LocalDate startDate;
	private LocalDate endDate;
	private String information;
	
	public PromoCodesBean() {
	}

	public PromoCodesBean(int promoId, String promoCode, double discountPercent, LocalDate startDate, LocalDate endDate,
			String information) {
		super();
		this.promoId = promoId;
		this.promoCode = promoCode;
		this.discountPercent = discountPercent;
		this.startDate = startDate;
		this.endDate = endDate;
		this.information = information;
	}

	public int getPromoId() {
		return promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	
	
	

}
