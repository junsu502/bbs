package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpEx1 {
//	4.실행과 리턴

	public static void main(String[] args) {
//		1.Driver connect
		String url = null;
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "scott", "1234");

		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
		
		try {
			Statement pstmt = con.createStatement();
			String query = "select * from EMP";
			
			ResultSet rs = pstmt.executeQuery(query);
			while(rs.next()) {
				int empno = rs.getInt(1);
				String en = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				Date hdt = rs.getDate(5);
				String sal = rs.getString(6);
				String comm = rs.getString(7);
				String dpt = rs.getString(8);
				System.out.println(empno+", "+en+", "+job+", "+mgr+", "+hdt+", "+sal+", "+comm+", "+dpt);
			}
		} catch (SQLException e) {
		}System.out.println("종료");
		
//		2.admin connect

//		3.Query

//		4.실행과 리턴

//		5.DB종료
	}

}
