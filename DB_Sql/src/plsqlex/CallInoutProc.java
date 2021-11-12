package plsqlex;

import java.sql.*;
import java.io.*;
import java.util.*;

public class CallInoutProc extends Object {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

// DB 접속
		String url = null;
		Connection con = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		url = "jdbc:oracle:thin:@localhost:1521:orcl";

// 변수 선언
		String p1value = new String("a");
		String p2value = new String("b");
		String p3value;

// 수행결과 출력
		con = DriverManager.getConnection(url, "javalink", "javalink");
		CallableStatement cs = con.prepareCall("{call javatest(?,?,?)}");
		
		cs.setString(1,p1value);
		cs.setString(2, p2value);
		cs.registerOutParameter(2, Types.VARCHAR);
		
		cs.registerOutParameter(3, Types.VARCHAR);
		
		cs.execute();
		p2value = cs.getString(2);
		p3value = cs.getString(3);
		
		System.out.println("p2 :" + p2value);
		System.out.println("p3 :" + p3value);
	}
}
