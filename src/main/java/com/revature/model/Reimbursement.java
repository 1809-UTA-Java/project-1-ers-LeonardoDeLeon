package com.revature.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	private int reimbursementId;
	private double amount;
	private String description;
	private Blob receipt;
	private Timestamp submitted;
	private Timestamp resolved;
	private int authorId;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbursementId, double amount, String description, Blob receipt, Timestamp submitted,
			Timestamp resolved, int authorId, int resolverId, int reimbursementType, int reimbursementStatus) {
		super();
		this.reimbursementId = reimbursementId;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.reimbursementType = reimbursementType;
		this.reimbursementStatus = reimbursementStatus;
	}

	private int resolverId;
	private int reimbursementType;
	private int reimbursementStatus;

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", amount=" + amount + ", description="
				+ description + ", receipt=" + receipt + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", authorId=" + authorId + ", resolverId=" + resolverId + ", reimbursementType=" + reimbursementType
				+ ", reimbursementStatus=" + reimbursementStatus + "]";
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(int reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public int getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(int reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

}
