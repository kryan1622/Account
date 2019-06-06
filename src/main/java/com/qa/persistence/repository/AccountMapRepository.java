package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;


@Alternative
public class AccountMapRepository implements AccountRepository {

	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();
	JSONUtil j1 = new JSONUtil();

	
	// You must provide concrete implementation for each of these methods
	// do not change the method signature
	// THINK - if the parameter is a String, or the return type is a String
	// How can I convert to a String from an Object?
	// What utility methods do I have available?

	// You must complete this section using TDD
	// You can use the suggested tests or build your own.

	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	
	public String getAllAccounts() {
		return j1.getJSONForObject(accountMap.values());
	}

	public String createAccount(String Account) {
		Account a1 = j1.getObjectForJSON(Account, Account.class);
		accountMap.put(a1.getAccountnumber(), a1);
		return "Account successfully created";
	}

	public String deleteAccount(int accountNumber) {
		accountMap.remove(accountNumber);
		return "";
	}

	public String updateAccount(int accountNumber, Account Account) {
		accountMap.replace(accountNumber, Account);
		return "";
	}

	public String updateAccount(int accountNumber, String Account) {
		Account a2 = j1.getObjectForJSON(Account, Account.class);

		if (accountMap.containsKey(accountNumber)) {
			accountMap.replace(accountNumber, a2);
			return "Account added" + j1.getJSONForObject(accountMap.values());
		}

		return "it hasnt worked";
	}
	
	public int searchList(String input) {
	return (int) this.accountMap.values().stream().filter(account->account.getFirstname().equals(input)).count();
	
//	int counter=0;
//	for (int i=0; i<=accountMap.size(); i++) {
//		if(getAccountMap().get(i).getFirstname().equals(Account)) {
//			counter++;
//		}
//	}
//			return counter;



}


	@Override
	public String findAccount(int ID) {
		return null;
	}
}