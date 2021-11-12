package test4.mvc;

import java.util.Scanner;
import java.util.Vector;

public class ServiceImpl implements Service {
	Scanner sc = new Scanner(System.in);
	DAO dao = new OracleDAO();

	@Override
	public void addProduct() {//insert
		System.out.println("제품이름:");
		String name = sc.next();
		System.out.println("제품가격:");
		int price = sc.nextInt();
		dao.insert(new Product(0,name,price));
	}

	@Override
	public void editProduct() {//update
		System.out.println("수정할 제품번호:");
		int num = sc.nextInt();
		Product p = dao.select(num);
		System.out.println(p);
		System.out.println("새 제품이름:");
		String name = sc.next();
		p.setName(name);
		System.out.println("새 제품가격:");
		int price = sc.nextInt();
		p.setPrice(price);
	
		dao.update(p.getNum(),p);
	}

	@Override
	public void delProduct() {//delete
		System.out.println("삭제할 제품번호:");
		int num = sc.nextInt();
		dao.delete(num);

	}

	@Override
	public Product getProduct() {//select one
		System.out.println("검색할 제품번호:");
		int num = sc.nextInt();
		Product p = dao.select(num); 
		return p;
	}

	@Override
	public Vector<Product> getProducts() {// select all
		Vector<Product> v = dao.selectAll();
		return v;
	}

}
