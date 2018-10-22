package com.revature.repository;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.revature.model.ExpenseReimbursement;
import com.revature.model.Users;

import com.revature.util.DbConnUtil;

import oracle.jdbc.internal.OracleTypes;

public class ErsDao {
	public List<Users> getEmployees() {
		CallableStatement cs = null;

		Users u = null;
		List<Users> users = new ArrayList<Users>();

		try (Connection conn = DbConnUtil.getDbConnect()) {
			String sql = "{ CALL GET_USERS_BY_ROLE_ID(?) }";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
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

	public Users getEmployeeById(int userId) {
		PreparedStatement ps = null;
		Users e = null;

		try (Connection conn = DbConnUtil.getDbConnect()) {
			String sql = "SELECT * FROM users WHERE USER_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int uId = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				int roleId = rs.getInt("role_id");

				e = new Users(uId, username, password, firstName, lastName, email, roleId);
			}

			rs.close();
			ps.close();
		} catch (SQLException ex) {
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}

		return e;
	}

	public void submitRequest(int amount, int authorId, int expRbmTypeId) {
		PreparedStatement ps = null;
		try (Connection conn = DbConnUtil.getDbConnect()) {

			String sql = "INSERT INTO EXPENSE_REIMBURSEMENTS (er_amount, er_desc, receipt, submitted, resolved, author_id, resolver_id, er_type, er_status) VALUES (?,null,null,current_timestamp,null,?,null,?,105)";       
																																							
			ps = conn.prepareStatement(sql);
			ps.setInt(1, amount);
			ps.setInt(2, authorId);
			ps.setInt(3, expRbmTypeId);
			ps.executeQuery();
			ps.close();
		} catch (SQLException ex) {
			//System.out.println("ex --- "+ex);
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void approveRequest(int expRbmId) {
		PreparedStatement ps = null;
		try (Connection conn = DbConnUtil.getDbConnect()) {

			String sql = "UPDATE EXPENSE_REIMBURSEMENTS SET RESOLVED = CURRENT_TIMESTAMP, RESOLVER_ID = 108, ER_STATUS = 210 WHERE ER_ID=?";     		
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, expRbmId);
			ps.executeQuery();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ex --- "+ex);
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void denyRequest(int expRbmId) {
		PreparedStatement ps = null;
		try (Connection conn = DbConnUtil.getDbConnect()) {

			String sql = "UPDATE EXPENSE_REIMBURSEMENTS SET RESOLVED = CURRENT_TIMESTAMP, RESOLVER_ID = 108, ER_STATUS = 205 WHERE ER_ID=?";     		
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, expRbmId);
			ps.executeQuery();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ex --- "+ex);
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void updateInfo(String password, int userId) {
		PreparedStatement ps = null;
		try (Connection conn = DbConnUtil.getDbConnect()) {

			String sql = "UPDATE USERS SET PASSWORD=? WHERE USER_ID=?";     		
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, userId);
			ps.executeQuery();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ex --- "+ex);
			ex.getMessage();
		} catch (IOException ex) {
			ex.getMessage();
		}
	}
	
	public List<ExpenseReimbursement> getPendingRequest() {
		CallableStatement cs = null;

		ExpenseReimbursement er = null;
		List<ExpenseReimbursement> expRbmList = new ArrayList<ExpenseReimbursement>();

		try (Connection conn = DbConnUtil.getDbConnect()) {
			String sql = "{ CALL GET_PENDING_REQUEST(?) }";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				int expRbmId = rs.getInt("er_id");
				double amount = rs.getDouble("er_amount");
				String expRbmDesc = rs.getString("er_desc");
				Blob receipt = rs.getBlob("receipt");
				Timestamp submitted = rs.getTimestamp("submitted");
				Timestamp resolved = rs.getTimestamp("resolved");
				int authorId = rs.getInt("author_id");
				int resolverId = rs.getInt("resolver_id");
				int expRbmTypeId = rs.getInt("er_type");
				int expRbmStatusId = rs.getInt("er_status");

				er = new ExpenseReimbursement(expRbmId, amount, expRbmDesc, receipt, submitted, resolved, authorId,
						resolverId, expRbmTypeId, expRbmStatusId);

				expRbmList.add(er);
			}

			cs.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return expRbmList;
	}

	public List<ExpenseReimbursement> getApprovedRequest() {
		CallableStatement cs = null;

		ExpenseReimbursement er = null;
		List<ExpenseReimbursement> expRbmList = new ArrayList<ExpenseReimbursement>();

		try (Connection conn = DbConnUtil.getDbConnect()) {
			String sql = "{ CALL GET_APPROVED_REQUEST(?) }";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				int expRbmId = rs.getInt("er_id");
				double amount = rs.getDouble("er_amount");
				String expRbmDesc = rs.getString("er_desc");
				Blob receipt = rs.getBlob("receipt");
				Timestamp submitted = rs.getTimestamp("submitted");
				Timestamp resolved = rs.getTimestamp("resolved");
				int authorId = rs.getInt("author_id");
				int resolverId = rs.getInt("resolver_id");
				int expRbmTypeId = rs.getInt("er_type");
				int expRbmStatusId = rs.getInt("er_status");

				er = new ExpenseReimbursement(expRbmId, amount, expRbmDesc, receipt, submitted, resolved, authorId,
						resolverId, expRbmTypeId, expRbmStatusId);

				expRbmList.add(er);
			}

			cs.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return expRbmList;
	}

	public List<ExpenseReimbursement> getDeniedRequest() {
		CallableStatement cs = null;

		ExpenseReimbursement er = null;
		List<ExpenseReimbursement> expRbmList = new ArrayList<ExpenseReimbursement>();

		try (Connection conn = DbConnUtil.getDbConnect()) {
			String sql = "{ CALL GET_DENIED_REQUEST(?) }";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				int expRbmId = rs.getInt("er_id");
				double amount = rs.getDouble("er_amount");
				String expRbmDesc = rs.getString("er_desc");
				Blob receipt = rs.getBlob("receipt");
				Timestamp submitted = rs.getTimestamp("submitted");
				Timestamp resolved = rs.getTimestamp("resolved");
				int authorId = rs.getInt("author_id");
				int resolverId = rs.getInt("resolver_id");
				int expRbmTypeId = rs.getInt("er_type");
				int expRbmStatusId = rs.getInt("er_status");

				er = new ExpenseReimbursement(expRbmId, amount, expRbmDesc, receipt, submitted, resolved, authorId,
						resolverId, expRbmTypeId, expRbmStatusId);

				expRbmList.add(er);
			}

			cs.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return expRbmList;
	}

	public List<ExpenseReimbursement> getExpRbmRequest() {
		CallableStatement cs = null;

		ExpenseReimbursement er = null;
		List<ExpenseReimbursement> expRbmList = new ArrayList<ExpenseReimbursement>();

		try (Connection conn = DbConnUtil.getDbConnect()) {
			String sql = "{ CALL GET_ER_REQUEST(?) }";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				int expRbmId = rs.getInt("er_id");
				double amount = rs.getDouble("er_amount");
				String expRbmDesc = rs.getString("er_desc");
				Blob receipt = rs.getBlob("receipt");
				Timestamp submitted = rs.getTimestamp("submitted");
				Timestamp resolved = rs.getTimestamp("resolved");
				int authorId = rs.getInt("author_id");
				int resolverId = rs.getInt("resolver_id");
				int expRbmTypeId = rs.getInt("er_type");
				int expRbmStatusId = rs.getInt("er_status");

				er = new ExpenseReimbursement(expRbmId, amount, expRbmDesc, receipt, submitted, resolved, authorId,
						resolverId, expRbmTypeId, expRbmStatusId);

				expRbmList.add(er);
			}

			cs.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return expRbmList;
	}

	public static void main(String[] args) throws SQLException {
		ErsDao ers = new ErsDao();
//		List<Users> userList = ers.getEmployees();
//		
//		for (Users u : userList) {
//			System.out.println(u.toString());
//		}
//		
//		System.out.println(ers.getEmployeeById(107));
//		
	
		//ers.submitRequest(1200, 107, 124);
		
		//ers.approveRequest(1576);
		
//		ers.denyRequest(1584);
//		
//		List<ExpenseReimbursement> expRbmList = ers.getPendingRequest();
//		System.out.println("expRbmList.size(): " + expRbmList.size());
//		for (ExpenseReimbursement er : expRbmList) {
//			System.out.println(er.toString());
//		}
//		List<ExpenseReimbursement> expRbmList2 = ers.getApprovedRequest();
//		System.out.println("expRbmList2.size(): " + expRbmList2.size());
//		for (ExpenseReimbursement er : expRbmList2) {
//			System.out.println(er.toString());
//		}
		List<ExpenseReimbursement> expRbmList3 = ers.getDeniedRequest();
		System.out.println("expRbmList3.size(): " + expRbmList3.size());
		for (ExpenseReimbursement er : expRbmList3) {
			System.out.println(er.toString());
		}
		
		ers.updateInfo("boba321", 105);
	}

}
