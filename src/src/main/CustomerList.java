package src.main;

import java.util.Arrays;

public class CustomerList{

	private static User_Accounts_Info[] users_account_info = new User_Accounts_Info[2];

	public static void add_account_to_DB(User_Accounts_Info signedUpAccount) {
		try {
			users_account_info[User_Accounts_Info.getAccount_info_index()] = signedUpAccount;
		}
		catch (ArrayIndexOutOfBoundsException err){
			users_account_info = Arrays.copyOf(users_account_info,users_account_info.length<<1);
			users_account_info[User_Accounts_Info.getAccount_info_index()] = signedUpAccount;
		}

	}
	
	

	public static User_Accounts_Info[] getCxList() {

		int count=0;
		for (User_Accounts_Info account_info : users_account_info) {
			if(account_info == null) {}
			else {
				count++;
			}

		}

		User_Accounts_Info[] list = new User_Accounts_Info[count];

		int index=0;
		for (User_Accounts_Info account_info : users_account_info) {
			if(account_info == null) {}
			
			else {		
				list[index++] = account_info;	
			}

		}

		return list;
	}





}
