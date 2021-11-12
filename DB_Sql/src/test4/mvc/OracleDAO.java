package test4.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class OracleDAO implements DAO {

	Scanner sc = new Scanner(System.in);
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	public OracleDAO() {
		DBConnect db = DBConnect.getInstance(); // singleton 객체생성
		conn = db.getConnection();// DB연결
	}

	@Override
	public void insert(Product p) {
		String sql = "insert into db values(db_seq.nextval,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("데이터가 저장되었습니다.");
			} else {
				System.out.println("데이터가 저장되지 않습니다.");
			}

		} catch (SQLException e) {
		}
		System.out.println("insert complite");

	}

	@Override
	public Product select(int num) {
		Product p = null;
		String sql = "select * from db where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
//				int num2 = rs.getInt(1);
				String name = rs.getString("name");
				int price = rs.getInt("price");
				p = new Product(num, name, price);
//				System.out.println(num + " : " + name + " : " + price);
			}

		} catch (SQLException e) {
		}

		return p;
	}

	@Override
	public Vector<Product> selectAll() {
		Product p = null;
		String sql = "select * from db order by num";
		Vector<Product> v = new Vector<Product>();
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int num2 = rs.getInt(1);
				String name = rs.getString("name");
				int price = rs.getInt("price");
				p = new Product(num2, name, price);
//				System.out.println(num2 + " : " + name + " : " + price);
				v.add(p);
			}

		} catch (SQLException e) {
		}

		return v;
	}

	@Override
	public void delete(int num) {
		String sql = "delete db where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("데이터가 저장되었습니다.");
			} else {
				System.out.println("데이터가 저장되지 않습니다.");
			}
		} catch (SQLException e) {
			System.out.println("오류");
		}

		System.out.println("done.");
	}

	@Override
	public void update(int num, Product p) {
		String sql = "update db set name=?,price=? where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setInt(3, num);
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("업데이트가 되었습니다.");
			} else {
				System.out.println("업데이트가 되지 않습니다.");
			}
		} catch (SQLException e) {
			System.out.println("오류");
		}

		System.out.println("done.");

	}

}
