package test4.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤
public class DBConnect {

	private static DBConnect db = new DBConnect();
	private Connection conn = null;

	String jdbc_driver = ("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	private DBConnect() {
		try {
			Class.forName(jdbc_driver);

		} catch (ClassNotFoundException e) {
		}
	}

	public static DBConnect getInstance() {
		return db;
	}// singleton

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, "javalink", "javalink");
		} catch (SQLException e) {
		}
		return conn;
	}// DB연결

}
