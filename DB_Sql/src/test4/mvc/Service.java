package test4.mvc;

import java.util.Vector;

public interface Service {

	void addProduct();
	
	void editProduct();
	
	void delProduct();
	
	Product getProduct();
	
	Vector<Product> getProducts();
	
}
