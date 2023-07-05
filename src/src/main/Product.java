package src.main;

import java.util.Random;

public class Product {

	private Random random = new Random();
	private static int product_count=0;
	private String id;
	private String product_name;
	private String catagory_name;
	private double price;
	
	{
		product_count++;
		id = random.ints(103, 999999).findFirst().getAsInt()+""+product_count;
		
	}
	
	public Product(String productName,String catagoryName, double price) {
		this.catagory_name = catagoryName;
		this.product_name=productName;
		this.price=price;
	}
	
	public String toString() {
		return "Product: [ id = "+getId()+" | Name= "+getProduct_name()+" | Catagory= "+getCatagory_name()+" | Price= "+getPrice()+"]\n";
	}

	
	public String getId() {
		return id;
	}

//	public void setId(String id) {
//		this.id = id;
//	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCatagory_name() {
		return catagory_name;
	}

	public void setCatagory_name(String catagory_name) {
		this.catagory_name = catagory_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
