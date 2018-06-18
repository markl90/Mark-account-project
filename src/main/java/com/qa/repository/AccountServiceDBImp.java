package com.qa.repository;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;
import java.util.Map;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Default
@Transactional(SUPPORTS)
public class AccountServiceDBImp implements Service {
	
	
	private JSONUtil util = new JSONUtil();
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	public Account findAccount(Long id) {
//		Account account = manager.find(Account.class, id);
//		if (account != null) {
//			return "{\"message\": \"account not found\"}";
//		}
//		else {
			return manager.find(Account.class, id);
		
    }
	
	
	@Transactional(REQUIRED)
    public void createAccount(String account) {		
        manager.persist(util.getObjectForJSON(account, Account.class));
        
    }
	
	@Transactional(REQUIRED)
	public void removeAccount(int id) {
		manager.remove(manager.find(Account.class, id));
	}
	
	
	public List<Account> findAllAccounts() {
        TypedQuery<Account> query = manager.createQuery("SELECT a FROM Account a ORDER BY a.id DESC", Account.class);
        return query.getResultList();
	}
	
	public void updateAccountFirstName(int id, String firstName) {	
		Account accountToUpdate = manager.find(Account.class, id);
		accountToUpdate.setFirstName(firstName);
		
		
	}
	
	public void updateAccountLastName(int id, String lastName) {	
		Account accountToUpdate = manager.find(Account.class, id);
		accountToUpdate.setFirstName(lastName);
		 
	}

}
