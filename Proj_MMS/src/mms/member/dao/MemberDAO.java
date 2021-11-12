package mms.member.dao;

import java.sql.Connection;
import java.util.ArrayList;

import mms.member.vo.Member;

public class MemberDAO {
	Connection con;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public int insertNewMember(Member newMember) {
// 데이터베이스 다녀오기 
		String sql = "insert into mms_member values()";
		
		
		return 0;

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
