package com.revature.model;

public interface Accessible {
	public boolean login(String username, String password);
	//public void login(String username, String password);
	
	public boolean logout(String username);
	
}
