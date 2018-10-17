package com.revature.model;

public interface Viewable {
	
	public static final int VIEW_ALL_EMP = 55;
	public static final int VIEW_EMP_HOME = 22;
	public static final int VIEW_EMP_INFO = 25;
	public static final int VIEW_MGR_HOME = 75;
	public static final int VIEW_PENDING_ER = 105;
	public static final int VIEW_RESOLVED_ER = 210;
	public static final int VIEW_IMAGE_OF_RCPT = 225;
	
	public boolean view(int viewChannel);	
}
