package plsqltest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureTest {

	Connection conn = null;
	PreparedStatement pstmt = null;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
		}
	}

	public void connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "1234");
			System.out.println("커넥트 완료");
		} catch (SQLException e) {
		}
	}

	public void insert() {
		connect();
		String sql = "insert into member2 values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Alpha");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "AI");
			pstmt.setInt(4, 20);
			pstmt.setString(5, "LA");
			pstmt.setString(6, "go@ai.com");
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("insert success!");
			} else {
				System.out.println("insert failed");
			}

		} catch (SQLException e) {
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public void select() {
		String sql = "select * from member2";
		ResultSet rs = null;
		connect();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print("아이디: " + rs.getString(1));
				System.out.print(", 비밀번호: " + rs.getString(2));
				System.out.print(", 이름: " + rs.getString(3));
				System.out.print(", 나이: " + rs.getInt(4));
				System.out.print(", 주소: " + rs.getString(5));
				System.out.println(", 이메일: " + rs.getString(6));
			}
		} catch (SQLException e) {
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
			}
			
		}

	}

	public void insertMember() {connect();
	String sql = "{call user_insert(?,?,?,?,?,?)}";
	CallableStatement cs = null;
	try {
		cs = conn.prepareCall(sql);
		cs.setString(1, "Procedure");
		cs.setString(2, "1234");
		cs.setString(3, "홍길동");
		cs.setInt(4, 19);
		cs.setString(5, "강원도");
		cs.setString(6, "hong@abc.com");
		int count = cs.executeUpdate();
		if (count > 0) {
			System.out.println("insert success!");
		} else {
			System.out.println("insert failed");
		}

	} catch (SQLException e) {
	} finally {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
		}
	}
		
	}

	public static void main(String[] args) {
		ProcedureTest pt = new ProcedureTest();
		System.out.println("*** 저장 프로시저 호출전 데이터 ***");
		pt.insert();
		pt.select();
		
		System.out.println("*** 저장 프로시저 호출후 데이터 ***");
//		pt.insert();
//		pt.select();
		
		
		
		
	}
}
