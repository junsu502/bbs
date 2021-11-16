package mms.member.svc;

import java.sql.Connection;
import java.util.ArrayList;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberListService {
	public ArrayList<Member> getMemberList() {
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberdao = new MemberDAO(con);
		ArrayList<Member> alm = memberdao.selectMemberList();
		
		JdbcUtil.close(con);
		return alm;
	}
}
