package test2.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AloneDAO {

	static Connection con = null;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "scott", "1234");
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
	}

	public void get() {
		String query = "select * from emp";
		ResultSet rs;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String a = rs.getString(1);

				System.out.println(a);

			}
			con.close();
		} catch (SQLException e) {
		}

	}

}
