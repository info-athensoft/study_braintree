package com.adogo.uaas.dao;

import java.util.List;

import com.adogo.uaas.entity.UserAccount;

public interface UserAccountDao {
	public List<UserAccount> find();
	public UserAccount findById(long acctId);
	
	public long create();
	public void update();
	public void delete();
}
