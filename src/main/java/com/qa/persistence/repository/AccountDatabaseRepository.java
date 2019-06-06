package com.qa.persistence.repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import com.qa.util.JSONUtil;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import javax.enterprise.inject.Default;
import com.qa.persistence.domain.Account;
import javax.inject.Inject;

@Transactional(SUPPORTS)
@Default
public class AccountDatabaseRepository implements AccountRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil j1;
	
	
    
	@Override
	@Transactional(REQUIRED)
	public String getAllAccounts() {
		Query query =  manager.createQuery("SELECT a FROM Account a");
		return j1.getJSONForObject(query.getResultList());

	}
    @Override
	@Transactional(SUPPORTS)
	public String findAccount(int ID) {
	return j1.getJSONForObject(manager.find(Account.class, ID));
	
	}
		
	@Override
    @Transactional(REQUIRED)
    public String createAccount(String account) {
        Account anAccount = j1.getObjectForJSON(account, Account.class);
        manager.persist(anAccount);
        return "{\"message\": \"account has been successfully added\"}";
	}
        
        
	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(int ID) {
		Account account = manager.find(Account.class, ID);

        if (manager.contains(account)) {
            manager.remove(account);
            return "{\"message\": \"Account sucessfully deleted " + ID + " \"}";
        }
        return "{\"message\": \"No account found with this id.\"}";
	}

	 @Override
	    @Transactional(REQUIRED)
	    public String updateAccount(int accountNumber, String account) {

	        Query query = manager.createQuery("Select a FROM Movie a WHERE a.accountNumber = :accountNumber");
	        query.setParameter("accountNumber", accountNumber);

	        Account oldAcc = (Account) query.getSingleResult();

	        Account newAcc = j1.getObjectForJSON(account, Account.class);

	        manager.remove(oldAcc);
	        manager.persist(newAcc);


	        return account;

}
}