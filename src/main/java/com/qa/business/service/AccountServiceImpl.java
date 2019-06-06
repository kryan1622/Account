package com.qa.business.service;
import javax.inject.Inject;
import com.qa.persistence.repository.AccountRepository;


public class AccountServiceImpl implements AccountService{
	
	@Inject 
	private AccountRepository AR;

	@Override
	public String createAccount(String Account) {
		return AR.createAccount(Account);
	}
	
	@Override
	public String deleteAccount(int accountNumber) {
		return AR.deleteAccount(accountNumber);
	}
	
	@Override
	public String getAllAccounts() {
		return AR.getAllAccounts();
	}
	
	@Override 
	public String findAccount(int ID) {
		return AR.findAccount(ID);
	}
	

}



