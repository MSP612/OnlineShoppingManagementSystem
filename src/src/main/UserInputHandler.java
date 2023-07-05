package src.main;

import java.util.*;

public class UserInputHandler extends User_Accounts_Info{

	private static String userID;
	private User_Accounts_Info signin;
	private static Scanner sc = new Scanner(System.in);


	private boolean switchCase_Before_Signin(String userInput ) {

		boolean flag =true;

		switch(userInput.toLowerCase())
		{

		case "1":{ //Sign Up
			System.out.print("First Name: ");
			String firstname = sc.next();

			System.out.print("Last Name: ");
			String lastname = sc.next();

			System.out.print("Password: ");
			String password = sc.next();

			System.out.print("Email Address: ");
			String email= sc.next();

			signin = new SignUp(firstname,  lastname,  password,  email);

			userID = signin.getID();

			if(userID.equals(INVALID)) {
				System.out.println("\nPlease provide valid details");	
			}
			else {
				((SignUp) signin).signup_Success();
				System.out.println("User created Successfully");	
				System.out.println("\nYOUR ID = "+userID+"\n\n");

			}
			break;
		}


		case "2":{//Sign In

			System.out.print("User ID: ");
			String userid=sc.next();

			System.out.print("Password: ");
			String password=sc.next();

			signin = new SignIn();
			signin = ((SignIn) signin).validate_Account(userid, password);
			try {
				userID = signin.getID();
			}
			catch(NullPointerException err) {
				userID = INVALID;
			}

			if(userID.equals(INVALID)) {
				System.out.println("\nUnfortunately, such login and password doesn’t exist");	
			}
			else {
				System.out.println("Glad to see you back "+signin.getFirstName()+" "+signin.getLastName());
			}

			break;	
		}


		case "3":{//Product Catalog
			String p_id =null;

			ProductCatalog cataLog = new ProductCatalog();
			for(Product product : ProductCatalog.products) {
				System.out.println(product.toString());
			}

			System.out.println("\nEnter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu : ");
			p_id = sc.next();

			if(p_id.equalsIgnoreCase("menu")){}
			else {
				System.out.println("You are not logged in. Please, sign in or create new account");
			}

			break;			
		}

		case "4":{//My Orders
			System.out.println("You are not logged in. Please, sign in or create new account");
			break;			
		}

		case "5":{//Settings

			break;			
		}

		case "6":{//Customer List

			System.out.println();
			for(User_Accounts_Info item : CustomerList.getCxList()) {
				System.out.println(item.toString());
			}
			break;			
		}

		case "exit":{
			flag=false;
			break;
		}

		default:	
			System.out.println("Only 1, 2, 3, 4, 5 or 6 is allowed. Try one more time.");
			break;
		}

		return flag;
	}


	private boolean switchCase_After_Signin(String userInput ) {

		boolean flag =true;

		switch(userInput.toLowerCase())
		{
		case "1":{//Sign Out
			userID =INVALID;
			System.out.println("\nHave a nice day! Look forward to welcoming back!\n");
			break;			
		}


		case "2":{//Product Catalog
			boolean loop=true;
			String p_id =null;
			ProductCatalog cataLog = new ProductCatalog();
			User_Accounts_Info.Cart cart = signin.new Cart();

			for(Product product : ProductCatalog.products) {
				System.out.println(product.toString());
			}

			while(loop) {

				if(p_id ==null) {
					System.out.println("\nEnter product id to add it to the cart or ‘menu’ if you want to navigate back to the main menu : ");
					p_id = sc.next();
				}

				if(p_id.equalsIgnoreCase("Menu")) {
					loop = false;
				}

				else if(p_id.equalsIgnoreCase("Checkout")){
					try {
						for(Product item: signin.myCart) {}
						int times_validate_creditCard=2;
						for(int i=1;i<=times_validate_creditCard;i++) {
							System.out.print("Enter your credit card number without spaces and press enter if you confirm purchase: ");
							if(signin.validate_CreditCard(sc.next())) {
								System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
								cart.clearCart();
								loop = false;
								break;
							}
							else if(i==times_validate_creditCard) {
								System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. "
										+ "Crossed limit, returning back to Main Menu");
							}
							else {
								System.out.print("You entered invalid credit card number. Valid credit card should contain 16 digits. "
										+ "Please, try one more time.");
							}
						}
						loop = false;

					}//Checkout ends here

					catch (NullPointerException err) {
						System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout.");
						p_id = null;
					}
				}
				else {
					if(cart.addToCart(p_id)) {
						System.out.println("\nIf you want to add a new product - enter the product id. If you want to proceed with checkout"
								+ " - enter word ‘checkout’ to console : ");
						p_id = sc.next();
					}
					else if(!cart.addToCart(p_id)){
						System.out.println("Incorrect Product ID."
								+ "\nPlease, enter product ID if you want to add product to cart.\n"
								+ "Or enter ‘checkout’ if you want to proceed with checkout.\n"
								+ "Or enter ‘menu’ if you want to navigate back to the main menu.");
						p_id = sc.next();
					}

				}

			}

			break;
		} 


		case "3":{//My Orders

			try {
				for(Product item: signin.myCart) {
					System.out.println(item.toString());
				}
			}
			catch (NullPointerException err) {
				System.out.println("Your cart is empty. Please, add product to cart first.");
			}

			break;			
		}

		case "4":{//Settings

			break;			
		}
		case "5":{//Customer List
			System.out.println();
			for(User_Accounts_Info item : CustomerList.getCxList()) {
				System.out.println(item.toString());
			}
			break;			
		}

		case "menu":{// main menu


			break;
		}

		case "exit":{
			flag = false;
			break;
		}
		default:
			System.out.println("Only 1, 2, 3, 4 or 5 is allowed. Try one more time.");
			break;
		}

		return flag;
	}


	public boolean menu() {
		if (userID == null) {
			return menu_before_signin();
		}
		else if(userID.equals(INVALID)) {
			return menu_before_signin();
		}
		else {
			return menu_after_signin();
		}

	}

	private boolean menu_before_signin() {
		System.out.println("\n"
				+ "1.	Sign Up\n"
				+ "2.	Sign In\r\n"
				+ "3.	Product Catalog\r\n"
				+ "4.	My Orders\r\n"
				+ "5.	Settings\r\n"
				+ "6.	Customer List\r\n");

		return switchCase_Before_Signin(sc.next());
	}

	private boolean menu_after_signin() {
		System.out.println("User ID: "+userID
				+ "\n"	
				+ "1.	Sign Out\r\n"
				+ "2.	Product Catalog\r\n"
				+ "3.	My Orders\r\n"
				+ "4.	Settings\r\n"
				+ "5.	Customer List\r\n");

		return switchCase_After_Signin(sc.next());
	}

}
