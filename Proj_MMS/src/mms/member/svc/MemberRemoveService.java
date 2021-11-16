package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;

public class MemberRemoveService {
	public boolean removeMember(String name) {
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberdao = new MemberDAO(con);
		int num = memberdao.deleteMember(name);
		if (num > 0) {
			JdbcUtil.commit(con);
			JdbcUtil.close(con);
			return true;
		} else {
			JdbcUtil.rollback(con);
			return false;
		}
		
	}
}
