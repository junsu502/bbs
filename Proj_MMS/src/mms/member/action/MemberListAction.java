package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberListService;
import mms.member.util.ConsoleUtill;

public class MemberListAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtill conutil = new ConsoleUtill();
		MemberListService mls = new MemberListService();
		conutil.printMemberList(mls.getMemberList());
		
	}

}
