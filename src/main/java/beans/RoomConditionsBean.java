package beans;

public class RoomConditionsBean {
	
	private int conditionId;
	private String conditionName;
	
	public RoomConditionsBean() {
	}

	public RoomConditionsBean(int conditionId, String conditionName) {
		super();
		this.conditionId = conditionId;
		this.conditionName = conditionName;
	}

	public int getConditionId() {
		return conditionId;
	}

	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	
	

}
