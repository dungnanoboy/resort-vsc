package beans;

public class UsersBean {
	
	private String email;
	private String password;
	private String fullName;
	private String mobile;
	private String address;
	private String gender;
	private String avatar;
	private int role;
	
	public UsersBean() {
	}

	public UsersBean(String emailId,  String passwordUser, String fullNameUser, String mobileNo, String addressUser, String genderUser, String avatarUser, int roleUser) {
		super();
		this.email = emailId;
		this.password = passwordUser;
		this.fullName = fullNameUser;
		this.mobile = mobileNo;
		this.address = addressUser;
		this.gender = genderUser;
		this.avatar = avatarUser;
		this.role = roleUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	


}
