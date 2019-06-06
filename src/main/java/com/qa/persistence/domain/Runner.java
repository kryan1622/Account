package com.qa.persistence.domain;

import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.repository.Constants;


public class Runner {
	public static void main(String[] args) {
		
		AccountMapRepository amr = new AccountMapRepository();
		amr.createAccount(Constants.ACCOUNT_ONE);
		amr.createAccount(Constants.ACCOUNT_TWO);
		System.out.println(amr.getAllAccounts());
		amr.deleteAccount(2);
		System.out.println(amr.getAllAccounts());
		System.out.println(amr.updateAccount(1, Constants.ACCOUNT_ONE_UPDATE));
		System.out.println(amr.getAllAccounts());
		System.out.println(amr.searchList("Krystal"));
		
//		JSONUtil j1 = new JSONUtil();
//		Account a1 = new Account("Krystal","Ryan");
//		Account a2 = new Account("Jack","Ryan");
//		System.out.println(j1.getJSONForObject(a1));
//		System.out.println(j1.getJSONForObject(a2));
		
	}

}
