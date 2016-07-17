package com.adogo.uaas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adogo.uaas.dao.UserAccountDao;
import com.adogo.uaas.entity.UserAccount;

@Service
public class UserAccountService {
	
	private UserAccountDao userAccoutDao;
	
	
	@Autowired
	@Qualifier("userAccountDaoParamImpl")
	public void setUserAccoutDao(UserAccountDao userAccoutDao) {
		this.userAccoutDao = userAccoutDao;
	}
	
	public List<UserAccount> getUserAccountAll(){
		return userAccoutDao.find();
	}
	
	public UserAccount getUserAccount(long acctId){
		return userAccoutDao.findById(acctId);
	}



	
}
