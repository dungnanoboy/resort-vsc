package beans;

public class BookingStateBean {
	
	private int stateId;
	private String stateName;
	
	public BookingStateBean() {
	}

	public BookingStateBean(int stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	

}
