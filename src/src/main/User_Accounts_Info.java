package src.main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

class User_Accounts_Info {
	private String firstName;
	private String lastName;
	private String passWord;
	private String eMail;
	private static int totalUsers = 0;
	private String ID;
	private static int account_info_index=-1;
	Random random = new Random();
	public static final String INVALID = "#NA";
	public static final String DUPLICATE = "NA";
	Product[] myCart ;



	{
		ID = random.ints(10003, 100000).findFirst().getAsInt()+"";
		totalUsers++;
		account_info_index++;
	}

	public static int getAccount_info_index() {
		return account_info_index;
	}


	public User_Accounts_Info() {

	}

	public User_Accounts_Info(String firstname, String lastname, String password, String email) {
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setEMail(email);
		this.setPassWord(password);
		this.before_setID();
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName.matches("[a-zA-Z]+")) {
			this.firstName = firstName;
		}
		else {
			this.firstName = INVALID;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName.matches("[a-zA-Z]+")) {
			this.lastName = lastName;
		}
		else {
			this.lastName = INVALID;
		}
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		if(passWord != null) {
			this.passWord = passWord;
		}
		else {
			this.passWord = INVALID;
		}
	}

	public String getEMail() {
		return eMail;
	}

	/**
	 * @param eMail = Email of user
	 */
	public void setEMail(String eMail) {

		if(eMail == null) {
			this.eMail = INVALID;
		}

		else {
			boolean flag = true;
			for (User_Accounts_Info account : CustomerList.getCxList()) {
				if(account.getEMail().equals(eMail)) {
					flag = false;
					this.eMail = DUPLICATE;
				}
			}

			if(flag) {
				this.eMail = eMail;
			}
		}

	}



	public String getID() {
		return ID;
	}

	private void setID() {
		this.ID = User_Accounts_Info.totalUsers+this.ID;
	}


	private void before_setID() {
		if(getFirstName().equals(INVALID) || getLastName().equals(INVALID) || getEMail().equals(INVALID) ||
				getPassWord().equals(INVALID) || getEMail().equals(DUPLICATE))
		{
			this.ID = INVALID;
			totalUsers--;
			account_info_index--;
		}

		else {
			setID();
		}
	}
	
	public boolean validate_CreditCard(String card_number) {
		if(card_number.length()==16 && card_number.matches("[0-9]+")) { //validate should only be numbers
//			for(int i =0;i<card_number.length();i++) {
//				Integer.parseInt(card_number, card_number.charAt(i)); 
//			}
			return true;
		}
		return false;
	}

	/**
	 * <pre>Method to create String of User Account Info</pre>>
	 **/
	public String toString() {
		return "Account: [ First Name= "+getFirstName()+" | Last Name= "+getLastName()+" | Email Address= "+getEMail()+" | User ID= "
				+getID()+"]\n";
	}



	class Cart {

		private Product[] itemList = new Product[10];
		int index=0;
		boolean product_found = false;

		public boolean addToCart(String product_id) {

			for(Product product : ProductCatalog.products) {

				if(product.getId().equals(product_id)) {
					try {
						itemList[index++] = product;
					}
					catch (ArrayIndexOutOfBoundsException err){
						itemList = Arrays.copyOf(itemList,itemList.length<<1);
						itemList[index] = product;
					}
					System.out.println("Product "+product.getProduct_name()+" has been added to your cart");
					
					//excluding null to avoid any error
					int count=0;
					for(Product item: itemList) {
						if(item ==null) {}
						else {
							count++;
						}
					}

					myCart = new Product[count];
					int index=0;
					for(Product item: itemList) {
						if(item ==null) {}
						else {
							myCart[index++] = item;
						}
					}
					return true;

				}//if productmatches ends here
			}//for ends here

			return false;
		}

		
		public void clearCart() {
			myCart = null;			
		}

	}






}






