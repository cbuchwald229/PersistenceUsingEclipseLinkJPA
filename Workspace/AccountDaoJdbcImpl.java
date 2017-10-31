package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoJdbcImpl implements AccountDao
{
	private Map<Long, Account> accountsMap = new HashMap<Long, Account>();
	{
		Account account1 = new Account(1L, "John", 10);
		Account account2 = new Account(2L, "Mary", 20);
		
		accountsMap.put(account1.getId(), account1);
		accountsMap.put(account2.getId(), account2);
	}
	
	public void insert(Account account){}
	public void update(Account account){}
	public void update(List<Account>accounts){}
	public void delete(long accountId){}
	public Account find(long accountId)
	{
		return accountsMap.get(accountId);
	}
	public List<Account>find(List<Long>accountIds)
	{
		List<Account> accounts = new ArrayList<Account>();
		for(Long id: accountIds)
		{
			accounts.add(accountsMap.get(id));
		}
		return accounts;
	}
	public List<Account>find(String ownerName)
	{
		List<Account>accounts = new ArrayList<Account>();
		for(Account account: accountsMap.values())
		{
			if(ownerName.equals(account.getOwnerName()))
			{
				accounts.add(account);
			}
		}
		return accounts;
	}
	public List<Account>find(boolean locked)
	{
		List<Account>accounts = new ArrayList<Account>();
		for(Account account: accountsMap.values())
		{
			if(locked == (account.isLocked()))
			{
				accounts.add(account);
			}
		}
		return accounts;
	}
}
