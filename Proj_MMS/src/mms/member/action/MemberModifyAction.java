package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberModifyService;
import mms.member.util.ConsoleUtill;
import mms.member.vo.Member;

public class MemberModifyAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtill cu = new ConsoleUtill();
		String oldname = cu.getName("수정함",sc);
		MemberModifyService mms = new MemberModifyService();
		Member oldmember = mms.getOldMember(oldname);
		Member updatemember = cu.getUpdateMember(sc, oldmember);
		boolean success = mms.modifyMember(updatemember);
		if (success)
			cu.printModifySuccessMessage(updatemember);
		else
			cu.printModifyFailMessage(updatemember);
	}

}
