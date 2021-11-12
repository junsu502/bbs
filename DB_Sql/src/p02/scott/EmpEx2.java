package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpEx2 {
	//Scanner 입력을 받아서 empno=7902 , scott pk를 통해 튜플 출력 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		1.Driver connect
		String url = null;
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:orcl";
//			2.계정 connect
			con = DriverManager.getConnection(url, "scott", "1234");

		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		}
		
		try {
			
			System.out.println("원하시는 column을 입력하세요.");
			String scsc = sc.next();
			System.out.println("원하시는 "+scsc+" 의 key값을 입력하세요.");
			int a = sc.nextInt();
//			3.Query
			String query = "select * from EMP where "+scsc+"="+a;
			
//			4.실행과 리턴

			Statement pstmt = con.createStatement();
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
				rs.close();
			}
		} catch (SQLException e) {
		}System.out.println("종료");
	
		



//		5.DB종료
		sc.close();
		
	}

}
