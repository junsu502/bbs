package study07_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDTest {

	Connection con;
	Statement stmt = null;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	public void connect() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url, "javalink", "javalink");
			stmt = con.createStatement();

			System.out.println("커넥트 되었습니다.");
		} catch (SQLException e) {

		}

	}

	public void insert() {
		try {
			String query = "insert into member1 values('aaa','1111','홍길동','22','서울시','hong@hong.com')";
			int count = stmt.executeUpdate(query);
			if (count > 0) {
				System.out.println("데이터가 삽입되었습니다.");
			} else {
				System.out.println("삽입될 데이터가 존재하지 않습니다.");
			}

		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

	public void select() {
		String query = "select * from member1";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString("name");
				String age = rs.getString("age");
				String addr = rs.getString("addr");
				String email = rs.getString("email");
				System.out.println(id + " : " + password + " : " + name + " : " + age + " : " + addr + " : " + email);
			}
		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
		}

	}

	public void update() {
		try {
			String query = "update member1 set addr = '부산시' where id = 'aaa'";
			int count = stmt.executeUpdate(query);
			if (count > 0) {
				System.out.println("데이터가 업데이트 되었습니다.");
			} else {
				System.out.println("업데이트할 데이터가 존재하지 않습니다.");
			}

		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

	public void delete() {
		try {
			String query = "delete member1 where id = 'aaa'";
			int count = stmt.executeUpdate(query);
			if (count > 0) {
				System.out.println("데이터가 삭제 되었습니다.");
			} else {
				System.out.println("삭제할 데이터가 존재하지 않습니다.");
			}

		} catch (SQLException e) {
		}
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

	public static void main(String[] args) {
		CRUDTest st = new CRUDTest();

		st.connect();
		st.insert();
		System.out.println("insert 수행 후");
		st.connect();
		st.select();
		System.out.println("update 수행 후");
		st.connect();
		st.update();
		st.select();
		System.out.println("delete 수행 후");
		st.connect();
		st.delete();
		st.connect();
		st.select();
	}
}
