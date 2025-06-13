package service;

import java.util.List;

import beans.UsersBean;

public interface UsersService {

	public String registerUser(String emailId, String passwordUser, String fullNameUser, String mobileNo, String addressUser,
			String genderUser, String avatarUser, int roleUser);

	public String registerUser(UsersBean user);

	public boolean isRegistered(String emailId);

	public boolean isValidCredential(String emailId, String passwordUser);

	public UsersBean getUsersDetails(String emailId, String passwordUser);

	public List<UsersBean> getAllUsers();

	public UsersBean getUserById(String email);

	

}
