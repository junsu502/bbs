package p02.scott;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpEx3 {
	// Scanner 입력을 받아서 empno=7902 , scott pk를 통해 튜플 출력
	// statement => preparedStatement
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
//		1.Driver connect
		String url = null;
		Connection con = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		url = "jdbc:oracle:thin:@localhost:1521:orcl";
//			2.계정 connect
		con = DriverManager.getConnection(url, "scott", "1234");

		int a = sc.nextInt();
//			3.Query
		String query = "select * from EMP where empno=?";

//			4.실행과 리턴

		PreparedStatement pstmt = con.prepareStatement(query); // 계정연결
		pstmt.setInt(1, a); // 첫번째 ?

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int empno = rs.getInt(1);
			String en = rs.getString(2);
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			Date hdt = rs.getDate(5);
			String sal = rs.getString(6);
			String comm = rs.getString(7);
			String dpt = rs.getString(8);
			System.out.println(
					empno + ", " + en + ", " + job + ", " + mgr + ", " + hdt + ", " + sal + ", " + comm + ", " + dpt);
		}
			System.out.println("종료");

//		5.DB종료
			rs.close();
			sc.close();
			con.close();
		}

	}

