package com.qa.business.service;

public interface AccountService {
	
	String getAllAccounts();
	String createAccount(String Account);
	String deleteAccount(int accountNumber);
	String findAccount(int ID);

}
