package src.main;

public class ProductCatalog {

	static Product[] products;


	public ProductCatalog() {

		products = new Product[] {
				new Product("Kesh Kanti","Shampoo",120),
				new Product("Dant Kanti","Tooth Paste",60),
				new Product("Babool","Tooth Paste",65.50),
				new Product("Colgate","Tooth Paste",80.90),
				new Product("Clinic Plus","Shampoo",150),
				new Product("Kachi Ghani Mustard Oil","Edible Oil",145),
				new Product("Edible Seesam Oil","Edible Oil",250),
				new Product("Coconut Hair Oil","Hair Oil",350),
				new Product("Lux","Body Soap",20),
				new Product("Haldi Chandan","Body Soap",20),
				new Product("Anti Wrinkle Cream","Face Cream",150),
				new Product("Gillet","Shaving Kit",250),
				new Product("Massager","Aquapressure Kit",550),
		};	
	}


}
