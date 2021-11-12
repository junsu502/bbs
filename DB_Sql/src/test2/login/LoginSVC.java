package test2.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginSVC {
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
			con = DriverManager.getConnection(url, "homework", "homework");
			System.out.println("커넥트 되었습니다.");
		} catch (SQLException e) {
			System.out.println("맞지 않습니다");
		}

	}
	public User login(String id, String passwd) {
		
		connect();
		User user = null;
		Statement stmt = null;
		
		try{
			stmt = con.createStatement();
			String sql = "SELECT * FROM member WHERE id = '" + id + "' AND " +	"password = '" + passwd + "'";			
			ResultSet rs = stmt.executeQuery(sql); //'aaa','aaa','홍길동',22,'남','a@a.com'
			if (rs.next()) {
				id = rs.getString(1);
				passwd = rs.getString(2);
				String name = rs.getString(3);
				int age = Integer.parseInt(rs.getString("age"));
//				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				System.out.println(id + " : " + passwd + " : " + name + " : " + age+ " : " + gender + " : " + email);
				user = new User(id,passwd,name,age,gender,email);
			}
		
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			try{
				stmt.close();
				con.close();
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return user;
	}

}
