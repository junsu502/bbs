package mms.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	static String url = null;
	static Statement stmt =null;
	static Connection con = null;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:orcl";
		} catch (ClassNotFoundException e) {
		}
	}
	public static Connection getConnection() {
		
		try {
			con = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = con.createStatement();
		} catch (SQLException e) {
		}
		return con;
	}
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	commit rollback
	
	
}
