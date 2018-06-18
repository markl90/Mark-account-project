package com.qa.repository;

import java.util.List;

import com.qa.domain.Account;

public interface Service {
	
	public Account findAccount(Long id);
	
	public void createAccount(String account);
	
	public void removeAccount(int id);
	
	public List<Account> findAllAccounts();
	
	public void updateAccountFirstName(int id, String firstName);
	
	public void updateAccountLastName(int id, String lastName);

}
