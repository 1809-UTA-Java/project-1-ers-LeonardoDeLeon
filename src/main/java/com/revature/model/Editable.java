package com.revature.model;

import java.sql.Timestamp;

public interface Editable {
	//public boolean upload(Image i);
	//public void upload(image i);
	public boolean upload();
	
	public boolean update(String username, String password);
	//public void update();
	
	public boolean submit(int authorId, double amount, Timestamp submitted, int expRbmTypeId);
	//public void submit();
		
}
