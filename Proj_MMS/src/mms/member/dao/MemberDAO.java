package mms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberDAO {
	Connection con;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public int insertNewMember(Member newMember) {
		String sql = "insert into mms_member values(mms_seq.nextval,?,?,?,?,?)";
		int count = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMember.getName());
			pstmt.setString(2, newMember.getAddr());
			pstmt.setString(3, newMember.getNation());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setInt(5, newMember.getAge());
			count = pstmt.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {

		}
		JdbcUtil.close(pstmt);

		return count;

	}

	public ArrayList<Member> selectMemberList() {
		String sql = "select * from mms_member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> alm = new ArrayList<Member>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				String name = rs.getString(2);
				String addr = rs.getString(3);
				String email = rs.getString(4);
				String nation = rs.getString(5);
				int age = rs.getInt(6);
				Member member = new Member(name, addr, nation, email, age);
				alm.add(member);
			}
		} catch (SQLException e) {
			System.out.println("selectMemberList failed");
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return alm;
	}

	public Member selectOldMember(String name) {
		String sql = "select * from mms_member where =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String ename = rs.getString("name");
				String addr = rs.getString("addr");
				String nation = rs.getString("nation");
				String email = rs.getString("email");
				int age = rs.getInt("age");
				member = new Member(ename, addr, nation, email, age);
			}
		} catch (SQLException e) {
			System.out.println("여긴가");
		}
		return member;
	}

	public int updateMember(Member updateMember) {

		String sql = "update mms_member set name=?, nation=?, email=?, age=?, addr=?";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			count = pstmt.executeUpdate();
			pstmt.setString(1, updateMember.getName());
			pstmt.setString(2, updateMember.getNation());
			pstmt.setString(3, updateMember.getEmail());
			pstmt.setInt(4, updateMember.getAge());
			pstmt.setString(5, updateMember.getAddr());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("업뎃안됨");
		}

		return count;

	}

	public int deleteMember(String name) {
		String sql = "delete mms_member set name=?";
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			count = pstmt.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			System.out.println("여기서 안됨");
		}

		return count;

	}
}
