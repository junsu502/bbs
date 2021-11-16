package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;

public class MemberAddService {
	public boolean addMember(Member newMember) throws Exception{
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberdao = new MemberDAO(con);
		int insertcount = memberdao.insertNewMember(newMember);
		if(insertcount > 0 ) {
			System.out.println("insert 되었습니다.");
			JdbcUtil.commit(con);
			return true;
		}else {
			System.out.println("insert 실패");
			JdbcUtil.rollback(con);
			return false;
		}

	}
}
