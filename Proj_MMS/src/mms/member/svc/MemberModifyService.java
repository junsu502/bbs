package mms.member.svc;

import java.sql.Connection;

import mms.member.dao.MemberDAO;
import mms.member.db.JdbcUtil;
import mms.member.vo.Member;
//8-3. 회원정보 수정 요청을 처리하는 Business Logic이 구현되는 Service 클래스 구현
public class MemberModifyService {
	public Member getOldMember(String name) {
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberdao = new MemberDAO(con);
		Member member = memberdao.selectOldMember(name);
		JdbcUtil.close(con);
		return member;
	
	}

	public boolean modifyMember(Member updateMember) {
		Connection con = JdbcUtil.getConnection();
		MemberDAO memberdao = new MemberDAO(con);
		int count = memberdao.updateMember(updateMember);
		if(count>0) {
			System.out.println("업데이트 완료");
			JdbcUtil.commit(con);
			JdbcUtil.close(con);
			return true;
		}else {
			System.out.println("업데이트 미완료");
			JdbcUtil.rollback(con);
			return false;
		}
		
	}
}
