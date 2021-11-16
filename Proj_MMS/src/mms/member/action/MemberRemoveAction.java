package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberRemoveService;
import mms.member.util.ConsoleUtill;

public class MemberRemoveAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		MemberRemoveService mrs = new MemberRemoveService();
		ConsoleUtill conutil = new ConsoleUtill();
		String name = conutil.getName("삭제할", sc);
		boolean result = mrs.removeMember(name);
		if(result) {
			conutil.printRemoveSuccessMessage(name);
		}else
			conutil.printRemoveFailMessage(name);
	}

}
