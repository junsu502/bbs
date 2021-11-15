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
	
	public static void commit() {
		String sql = "commit";
		try {
			int count = stmt.executeUpdate(sql);
			if(count>0) {
				System.out.println("커밋되었습니다.");
			}else {
				System.out.println("커밋되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback() {
		String sql = "rollback";
		try {
			int count = stmt.executeUpdate(sql);
			if(count>0) {
				System.out.println("롤백되었습니다.");
			}else {
				System.out.println("롤백되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
