package com.revature.model;

public interface Manager {
	public boolean login(String username, String password);
	//public void login(String username, String password);
	
	public boolean logout(String username);
	//public void logout(String username);
}
