package mms.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mms.member.util.ConsoleUtill;
import mms.member.vo.Member;

public class MemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ConsoleUtill cu = new ConsoleUtill();
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	public int insertNewMember(Member newMember) {
// 데이터베이스 다녀오기 
		
		String sql = "insert into mms_member values(member_id_seq.nextval,?,?,?,?,?)";
	    int insert = 0;
		try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, newMember.getName());
		pstmt.setString(2, newMember.getAddr());
		pstmt.setString(3, newMember.getNation());
		pstmt.setInt(4, newMember.getAge());
		insert = 1;
		
		////깃허브
			
		} catch (SQLException e) {
		System.out.println("양식에 맞게 써주시기 바랍니다.");
		}
		
		return insert;

	}

	public ArrayList<Member> selectMemberList() {
		
		String sql = "select * from ";
		return null;

	}

	public Member selectOldMember(String name) {
		
		String sql = "select sc from";
		
		return null;

	}

	public int updateMember(Member updateMember) {
		return 0;

	}

	public int deleteMember(String name) {
		return 0;

	}
}
