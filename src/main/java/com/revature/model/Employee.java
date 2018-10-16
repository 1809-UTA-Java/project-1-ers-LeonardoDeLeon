package com.revature.model;

import java.awt.Image;
import java.awt.image.BufferedImage;

public interface Employee {

	public boolean login(String username, String password);
	//public void login(String username, String password);
	
	public boolean logout(String username);
	//public void logout(username);
	
	public boolean upload(Image i);
	//public void upload(image i);
	
	public boolean update();
	//public void update();
}
