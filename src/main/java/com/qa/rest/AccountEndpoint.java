package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private AccountService service;
	
	
	@Path("/createAccount")
	@POST
	@Produces({"application/json"})
	public String createAccount(String Account) {
		return service.createAccount(Account);
	}
	
	@Path("/getAllAccounts")
	@GET
	@Produces({"application/json"})
	public String getAllAccounts() {
	return service.getAllAccounts();
	
}
	@Path("/deleteAccount/{accountNumber}")
	@DELETE
	@Produces({"application/json"})
	public String deleteMovie(@PathParam("accountNumber") int accountNumber) {
		return service.deleteAccount(accountNumber);
	}
	
	@Path("/findAccount/{ID}")
	@GET
	@Produces({"application/json"})
	public String findAccount(@PathParam("ID")int ID) {
		return service.findAccount(ID);
	}

}
