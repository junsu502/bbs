package test3;

import java.sql.SQLException;
import java.util.ArrayList;

public class SampleMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		SampleDAO dao = new SampleDAO();
		ArrayList<SampleDTO> books = dao.findAll();
		
		for(SampleDTO t:books) {
			System.out.println("id: "+t.getId()+ "\nname: "+ t.getName()+"\nprice: "+t.getPrice()+"\n");
		}
		
//		for(int i=0; i<books.size(); i++) {
//		System.out.println(books.get(i));
//		}
//		
//		dao.findAll();
	}

}
