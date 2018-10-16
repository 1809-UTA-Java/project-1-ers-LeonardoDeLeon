package com.revature.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UsersTest {
	Users u = new Users();
	
	@Test
	public void testLoginBothValid() {
	    boolean result = u.login("user3", "howtoprogramwithjava");
	    assertTrue(result);
	}
	
	@Test
	public void testLoginInvalidPassword() {
	    boolean result = u.login("Bob", "thispasswordisbad");
	    assertFalse(result);
	}
	
	@Test
	public void testLoginInvalidUsername() {
	    boolean result = u.login("FredBeGoodIsNotAUser", "12345");
	    assertFalse(result);
	}
}
