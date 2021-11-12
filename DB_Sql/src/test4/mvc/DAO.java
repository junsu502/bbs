package test4.mvc;

import java.util.Vector;

public interface DAO {

//	Product p = new Product();
	void insert(Product p);
	Product select(int num);
	Vector<Product> selectAll();
	void delete(int num);
	void update(int num,Product p);
}
