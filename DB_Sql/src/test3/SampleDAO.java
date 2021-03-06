package test3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SampleDAO {
	
	public ArrayList<SampleDTO> findAll() throws SQLException, ClassNotFoundException{
		SampleDTO sampleDTOs = null;
		ArrayList<SampleDTO> dto = new ArrayList<SampleDTO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Connection con = DriverManager.getConnection(url, "javalink", "javalink");
		String query = "select * from book";
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			
			String id = rs.getString(1);
			String name = rs.getString(2);
			int price = rs.getInt(3);
//			System.out.println("id: "+id+" name: "+name+" price: "+price);
		    sampleDTOs = new SampleDTO(id, name, price);
		    dto.add(sampleDTOs);
		    
		}
		con.close();
		rs.close();
		
		
		
		return dto;
		
		
		
	}
}
