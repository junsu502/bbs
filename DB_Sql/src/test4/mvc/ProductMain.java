package test4.mvc;

import java.util.Scanner;
import java.util.Vector;

public class ProductMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Service si = new ServiceImpl();

		while (true) {
			System.out.println("1.제품등록 2.제품검색 3.전체검색 4.수정 5.삭제 6.종료");
			int a = sc.nextInt();
			Vector<Product> v = null;
			switch (a) {
			case 1:
				si.addProduct();
				break;
			case 2:
				System.out.println(si.getProduct());
				break;
			case 3:
				v = si.getProducts();
				for(int i=0; i<v.size(); i++) {
					System.out.println(v.get(i));
				}
				break;
			case 4:
				si.editProduct();
				break;
			case 5:
				si.delProduct();
				break;
			case 6:
				break;
			default:
				System.out.println("다시 입력하세요.");
			}
			if(a == 6) {
				System.out.println("종료");
				break;
			}

		}

	}

}
