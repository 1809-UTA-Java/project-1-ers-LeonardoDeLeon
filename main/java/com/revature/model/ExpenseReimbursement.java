package com.revature.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExpenseReimbursement {

	private int expRbmId;
	private double amount;
	private String expRbmDesc;
	private Blob receipt;
	private Timestamp submitted;
	private Timestamp resolved;
	private int authorId;
	private int resolverId;
	private int expRbmTypeId;
	private int expRbmStatusId;

	public ExpenseReimbursement(int expRbmId, double amount, String expRbmDesc, Blob receipt, Timestamp submitted,
			Timestamp resolved, int authorId, int resolverId, int expRbmTypeId, int expRbmStatusId) {
		super();
		this.expRbmId = expRbmId;
		this.amount = amount;
		this.expRbmDesc = expRbmDesc;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.expRbmTypeId = expRbmTypeId;
		this.expRbmStatusId = expRbmStatusId;
	}

	public int getExpRbmId() {
		return expRbmId;
	}

	public void setExpRbmId(int expRbmId) {
		this.expRbmId = expRbmId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getExpRbmDesc() {
		return expRbmDesc;
	}

	public void setExpRbmDesc(String expRbmDesc) {
		this.expRbmDesc = expRbmDesc;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getExpRbmTypeId() {
		return expRbmTypeId;
	}

	public void setExpRbmTypeId(int expRbmTypeId) {
		this.expRbmTypeId = expRbmTypeId;
	}

	public int getExpRbmStatusId() {
		return expRbmStatusId;
	}

	public void setExpRbmStatusId(int expRbmStatusId) {
		this.expRbmStatusId = expRbmStatusId;
	}

	@Override
	public String toString() {
		return "ExpenseReimbursement [expRbmId=" + expRbmId + ", amount=" + amount + ", expRbmDesc=" + expRbmDesc
				+ ", receipt=" + receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", authorId="
				+ authorId + ", resolverId=" + resolverId + ", expRbmTypeId=" + expRbmTypeId + ", expRbmStatusId="
				+ expRbmStatusId + "]";
	}

	public ExpenseReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public List<ExpenseReimbursement> getExpRbmDummyTestData() {

		List<ExpenseReimbursement> expRbmList = new ArrayList<ExpenseReimbursement>();

		expRbmList.add(new ExpenseReimbursement(1050,35.49,"uber to hotel",null,Timestamp.valueOf("2018-09-18 10:10:10.000000000"),Timestamp.valueOf("2005-09-20 10:10:10.000000000"),105,108,120,105));
		expRbmList.add(new ExpenseReimbursement(1060,75.49,"lodging",null,Timestamp.valueOf("2018-09-21 10:10:10.000000000"),Timestamp.valueOf("2005-09-25 10:10:10.000000000"),106,108,122,105));
		expRbmList.add(new ExpenseReimbursement(1070,205.89,"flight",null,Timestamp.valueOf("2018-09-22 10:10:10.000000000"),Timestamp.valueOf("2005-09-25 10:10:10.000000000"),107,108,123,105));
		expRbmList.add(new ExpenseReimbursement(1070,325.89,"flight",null,Timestamp.valueOf("2018-09-23 10:10:10.000000000"),Timestamp.valueOf("2005-09-25 10:10:10.000000000"),107,108,123,210));
		
		return expRbmList;
	}

	public List<ExpenseReimbursement> getExpRbmDummyTestData2(int authorId, double amount, Timestamp submitted, int expRbmTypeId) {

		List<ExpenseReimbursement> expRbmList = new ArrayList<ExpenseReimbursement>();

		//expRbmList.add(new ExpenseReimbursement(1050,35.49,"uber to hotel",null,Timestamp.valueOf("2018-09-18 10:10:10.000000000"),Timestamp.valueOf("2005-09-20 10:10:10.000000000"),105,108,120,105));
		
		expRbmList.add(new ExpenseReimbursement(1000,amount,null,null,submitted,null,authorId,10,expRbmTypeId,105));
		
		return expRbmList;
	}
}
