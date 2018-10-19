package com.revature.model;

import java.util.List;
import java.util.ArrayList;

import com.revature.util.DbConnUtil;
import com.revature.repository.ErsDao;

public class Users implements Accessible, Viewable {

	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int userRoleId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Users(int userId, String username, String password, String firstName, String lastName, String email,
			int userRoleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRoleId = userRoleId;
	}

	public Users(String username, String password) {
		
		this.username = username;
		this.password = password;
	}

	public Users() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean login(String username, String password) {
		List<Users> users = getUserDummyTestData();

		for (Users aUser : users) {
			if (username.equals(aUser.getUsername()) && password.equals(aUser.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean logout(String username) {

		List<Users> users = getUserDummyTestData();

		for (Users aUser : users) {
			if (username.equals(aUser.getUsername())) {
				int initialSize = users.size();
				users.remove(aUser);
				if (initialSize > users.size())
					System.out.println(initialSize + " > " + users.size());

				return true;
			}
		}

		return false;
	}

	public List<Users> getUserDummyTestData() {

		List<Users> userList = new ArrayList<Users>();

		userList.add(new Users(105,"unobob","bob123","Bob","Uno","bob.uno@goog.gom",55));
		userList.add(new Users(106,"fortejoe23","joe123","Joe","Forte","joe.forte@goog.gom",55));
		userList.add(new Users(107,"reilolmarie","m4r1elo0","Marie","Lolier","Mae.lier@goog.gom",55));
		userList.add(new Users(108,"bannifred","frednni4","Fred","Banni","fred.nni@goog.gom",75));
		
		return userList;
	}

	public boolean view(int VIEW_CHANNEL) {
		
		// child class Manager and Employee will override view
		boolean isViewable = false;

		return isViewable;
	}
}
