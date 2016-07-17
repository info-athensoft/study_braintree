package com.adogo.uaas.entity;

import java.util.Date;

public class UserAccount {
	private long acctId;
	private String acctName;
	private String password;
	private String primaryEmail;
	private String secureEmail;
	private Date createDate;
	private Date lastModDate;
	private int acctStatus;
	
	public long getAcctId() {
		return acctId;
	}
	public void setAcctId(long acctId) {
		this.acctId = acctId;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	public String getSecureEmail() {
		return secureEmail;
	}
	public void setSecureEmail(String secureEmail) {
		this.secureEmail = secureEmail;
	}
	
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastModDate() {
		return lastModDate;
	}
	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}
	public int getAcctStatus() {
		return acctStatus;
	}
	public void setAcctStatus(int acctStatus) {
		this.acctStatus = acctStatus;
	}
	
	@Override
	public String toString() {
		return "UserAccount [acctId=" + acctId + ", acctName=" + acctName + ", password=" + password + ", primaryEmail="
				+ primaryEmail + ", secureEmail=" + secureEmail + ", createDate=" + createDate + ", lastModDate="
				+ lastModDate + ", acctStatus=" + acctStatus + "]";
	}
	
	
}
