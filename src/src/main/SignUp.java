package src.main;


class SignUp extends User_Accounts_Info{
	
	
	public SignUp() {
		
	}
	
	public SignUp(String firstname, String lastname, String password, String email) {
		super(firstname,lastname,password,email);
		validation("First Name",getFirstName());
		validation("Last Name",getLastName());
		validation("Email ",getEMail());
		validation("Password",getPassWord());
	}
	

	
	private void validation(String inputFieldName, String inputMethodName) {
		if(inputMethodName.equals(DUPLICATE)) {
			System.out.println("This "+inputFieldName+" is already used by another user. Please, use another "+inputFieldName);
		}
		if(inputMethodName.equals(INVALID)) {
			System.out.println("Invalid "+inputFieldName);
		}
		if(inputMethodName.equals(null)) {
			System.out.println(" You have to input "+inputFieldName+" to register.");			
		}
	}
	
	
	public void signup_Success() {
		CustomerList.add_account_to_DB(this);
	}
	
	
	
	
	
	
	
	
	
}
