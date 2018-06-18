package com.qa.repository;

import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class MapImpl implements Service {

	@Inject
	private Map<Integer, Account> accountMap;
	private JSONUtil util; 
	
	@Override
	public void createAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);
		accountMap.put((int) newAccount.getId(), newAccount);
		
	}

	@Override
	public void removeAccount(int id) {
		boolean countExists = accountMap.containsKey(id);
		if (countExists) {
			accountMap.remove(id);
		}
	}

	@Override
	public List<Account> findAllAccounts() {
		List<Account> accountList = (List<Account>)accountMap.values();
		return accountList;
	}

	@Override
	public void updateAccountFirstName(int id, String firstName) {
//		Account accountToUpdate = accountMap.get(id);
//		accountToUpdate.setFirstName(firstName);
		accountMap.get(id).setFirstName(firstName);
		
	}

	@Override
	public void updateAccountLastName(int id, String secondName) {
		Account accountToUpdate = accountMap.get(id);
		accountToUpdate.setSecondName(secondName);
		
	}

	@Override
	public Account findAccount(Long id) {
		return accountMap.get(id);
	}
	
	
	

}
