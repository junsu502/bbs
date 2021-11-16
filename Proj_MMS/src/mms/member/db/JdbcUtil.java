package mms.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	static Statement stmt =null;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
		}
	}
	public static Connection getConnection() {
		Connection con = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "scott", "scott");
			con.setAutoCommit(false);
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
	public static void close(PreparedStatement prestatement) {
		try {
			prestatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet resultset) {
		try {
			resultset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			System.out.println("commit success !");
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			System.out.println("rollback success !");
		}
	}
	
	
}
