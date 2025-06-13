package service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UsersBean;
import constants.IUsersConstants;
import service.UsersService;
import utility.DBUtil;
import utility.MailMessage;

public class UsersServiceImpl implements UsersService{
	
	@Override
	public String registerUser(String emailId,  String passwordUser, String fullNameUser, String mobileNo, String addressUser, String genderUser, String avatarUser, int roleUser) {

		UsersBean user = new UsersBean(emailId, passwordUser, fullNameUser, mobileNo, addressUser, genderUser, avatarUser, roleUser);

		String status = registerUser(user);

		return status;
	}
	
	@Override
	public String registerUser(UsersBean user) {

		String status = "User Registration Failed!";

		boolean isRegtd = isRegistered(user.getEmail());

		if (isRegtd) {
			status = "Email Id Already Registered!";
			return status;
		}
		Connection conn = DBUtil.provideConnection();
		PreparedStatement ps = null;
		if (conn != null) {
			System.out.println("Connected Successfully!");
		}

		try {

			ps = conn.prepareStatement("insert into " + IUsersConstants.TABLE_USERS + " values(?,?,?,?,?,?,?,?)");

			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullName());
			ps.setString(4, user.getMobile());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getGender());
			ps.setString(7, user.getAvatar());
			ps.setInt(8, user.getRole());

			int k = ps.executeUpdate();

			if (k > 0) {
				status = "User Registered Successfully!";
				MailMessage.registrationSuccess(user.getEmail(), user.getFullName().split(" ")[0]);
			}

		} catch (SQLException e) {
			status = "Error: " + e.getMessage();
			e.printStackTrace();
		}

		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(ps);

		return status;
	}
	
	@Override
	public boolean isRegistered(String emailId) {
		boolean flag = false;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from users where email=?");

			ps.setString(1, emailId);

			rs = ps.executeQuery();

			if (rs.next())
				flag = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return flag;
	}
	
	@Override
	public boolean isValidCredential(String emailId, String passwordUser) {
		boolean isValid = false;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = con.prepareStatement("select * from users where email=? and password=?");

			ps.setString(1, emailId);
			ps.setString(2, passwordUser);

			rs = ps.executeQuery();

			isValid = rs.next();

		} catch (SQLException e) {
			isValid = false; 
	        e.printStackTrace();
	    } finally {
	        DBUtil.closeConnection(con);
	        DBUtil.closeConnection(ps);
	        DBUtil.closeConnection(rs);
	    }

	    return isValid;
	}
	
	@Override
	public UsersBean getUsersDetails(String emailId, String passwordUser) {

		UsersBean user = null;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from users where email=? and password=?");
			ps.setString(1, emailId);
			ps.setString(2, passwordUser);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new UsersBean();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullname"));
				user.setMobile(rs.getString("mobile"));
				user.setAddress(rs.getString("address"));
				user.setGender(rs.getString("gender"));
				user.setAvatar(rs.getString("avatar"));
				user.setRole(rs.getInt("role"));

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return user;
	}
	
	@Override
	public List<UsersBean> getAllUsers() {
		List<UsersBean> users = new ArrayList<UsersBean>();

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from Users order by mobile");

			rs = ps.executeQuery();

			while (rs.next()) {

				UsersBean user = new UsersBean();

				user.setEmail(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setFullName(rs.getString(3));
				user.setMobile(rs.getString(4));
				user.setAddress(rs.getString(5));	
				user.setGender(rs.getString(6));
				user.setAvatar(rs.getString(7));
				user.setRole(rs.getInt(8));

				users.add(user);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);

		return users;
	}
	
	@Override
	public UsersBean getUserById(String email) {
		UsersBean user = null;

		Connection con = DBUtil.provideConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from Users where email=?");

			ps.setString(1, email);
			rs = ps.executeQuery();

			if (rs.next()) {
				user = new UsersBean();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullName(rs.getString("fullname"));
				user.setMobile(rs.getString("mobile"));
				user.setAddress(rs.getString("address"));
				user.setGender(rs.getString("gender"));
				user.setAvatar(rs.getString("avatar"));
				user.setRole(rs.getInt("role"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);

		return user;
	}

}
