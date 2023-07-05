package src.main;

public class SignIn extends User_Accounts_Info{

	
	public User_Accounts_Info validate_Account(String userid, String password) {
		
		for(User_Accounts_Info account : CustomerList.getCxList()) 
		{	
			
			if(account.getID().equals(userid) && account.getPassWord().equals(password)) {
				return account;
			}	
		}
		
		return null;
	}
	
	
	
	


	
}
