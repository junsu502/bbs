package plsql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class PlsqlProcedure {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//oracle DB연결
//		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		String url = null;
		Connection con = null;
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
			int p1InValue = Integer.parseInt(args[0]);//2
			int p2InOutValue = Integer.parseInt(args[1]);//3
			int p3OutValue;
			
			con = DriverManager.getConnection(url, "javalink", "javalink");
			CallableStatement cs = con.prepareCall("{call compute_power(?,?,?)}");
			cs.setInt(1, p1InValue);
			
			cs.setInt(2, p2InOutValue);
			cs.registerOutParameter(2, Types.INTEGER);
			
			cs.registerOutParameter(3, Types.INTEGER);
			
			cs.execute();
			
			p2InOutValue = cs.getInt(2);
			p3OutValue = cs.getInt(3);
			
			System.out.println(p1InValue+"^"+p2InOutValue+" = "+p3OutValue);
	}

}