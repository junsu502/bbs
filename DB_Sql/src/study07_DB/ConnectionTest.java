package study07_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	Connection con;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버가 없습니다.");
		}
	}

	public void connect() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "javalink", "javalink");
			System.out.println("커넥트 되었습니다.");
		} catch (SQLException e) {
			System.out.println("맞지 않습니다");
		}

	}

	public static void main(String[] args) {

		ConnectionTest ct = new ConnectionTest();
		ct.connect();
	}

}
