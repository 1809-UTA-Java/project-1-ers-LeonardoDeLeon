package com.revature.repository;

import java.util.List;
import java.util.ArrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.revature.model.Users;
import com.revature.util.DbConnUtil;

import oracle.jdbc.internal.OracleTypes;

public class ErsDao {
	public List<Users> getUsersByUserRoleId(int userRoleId) {
		CallableStatement cs = null;
		
		Users u = null;
		List<Users> users = new ArrayList<Users>();

		try(Connection conn = DbConnUtil.getDbConnect()) {
			String sql = "{ CALL GET_ALL_FROM_USERS(?) }";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				int roleId = rs.getInt("role_id");
				
				u = new Users(userId, username, password, firstName, lastName, email, roleId);
				users.add(u);
			}
			
			cs.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return users;
	}	
}
