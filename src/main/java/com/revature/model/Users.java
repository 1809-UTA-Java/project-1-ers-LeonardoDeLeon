package com.revature.model;

import java.util.List;
import java.util.ArrayList;

public class Users implements Viewable {

	private String username;
	private String password;

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
		List<Users> users = getDummyTestVariables();

		for (Users aUser : users) {
			if (username.equals(aUser.getUsername()) && password.equals(aUser.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean logout(String username) {
		return false;
	}

	public List<Users> getDummyTestVariables() {

		List<Users> userList = new ArrayList<Users>();

		// create a list of 10 users, each with user names
		// that increment (ie. user1, user2, user3, user4),
		// all these users will have the password set to
		// 'howtoprogramwithjava'
		for (int i = 0; i < 10; i++) {
			userList.add(new Users("user" + i, "howtoprogramwithjava"));
		}
		
		userList.add(new Users("Bob","12345"));
		userList.add(new Users("Fred","123Fred45"));

		return userList;
	}

}
