package com.qa.MapTests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {

	private AccountMapRepository amr;
	private Account acc1;
	private Account acc2;
	private String k;

	@Before
	public void setup() {
		amr = new AccountMapRepository();
		acc1 = new Account("Krystal", "Ryan");
		acc2 = new Account("Jack", "Ryan");
        k = "Krystal";
	}

	@Test
	public void addAccountTest() {
		amr.createAccount("{\"ID\":1,\"accountnumber\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}");
		assertEquals(1, amr.getAccountMap().size());
		assertEquals(k, amr.getAccountMap().get(1).getFirstname());
	}

	@Test
	public void add2AccountsTest() {
		amr.createAccount("{\"ID\":1,\"accountnumber\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}");
		amr.createAccount("{\"ID\":2,\"accountnumber\":2,\"firstname\":\"Jack\",\"lastname\":\"Ryan\"}");
		assertEquals(2, amr.getAccountMap().size());
		assertEquals(k, amr.getAccountMap().get(1).getFirstname());
	}

	@Test
	public void removeAccountTest() {

		amr.getAccountMap().put(1, acc1);

		amr.deleteAccount(1);
		assertEquals(0, amr.getAccountMap().size());
	}

	@Test
	public void remove2AccountsTest() {
		amr.getAccountMap().put(1, acc1);
		amr.getAccountMap().put(2, acc2);
		amr.deleteAccount(1);
		amr.deleteAccount(2);
		assertEquals(0, amr.getAccountMap().size());
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		amr.getAccountMap().put(1, acc1);
		amr.getAccountMap().put(2, acc2);
		amr.deleteAccount(1);
		amr.deleteAccount(2);
		amr.deleteAccount(3);
		assertEquals(0, amr.getAccountMap().size());
	}

	@Ignore
	@Test
	public void jsonStringToAccountConversionTest() {
		
	}

	@Ignore
	@Test
	public void accountConversionToJSONTest() {
		// testing JSONUtil
		fail("TODO");
	}

	@Ignore
	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Ignore
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality
		fail("TODO");
	}

	@Ignore
	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {
		// For a later piece of functionality
		fail("TODO");
	}
	

	@Ignore
	@Test
	public void lookthroughList() {
		amr.getAccountMap().put(1, acc1);
		amr.getAccountMap().put(2, acc2);
		assertEquals(1, amr.searchList(k));
	}

}
