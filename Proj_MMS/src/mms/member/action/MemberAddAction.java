package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtill;
import mms.member.vo.Member;

public class MemberAddAction implements Action{

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtill conutil = new ConsoleUtill();
		Member member = conutil.getNewMember(sc);
		MemberAddService memberadd = new MemberAddService();
		boolean success = memberadd.addMember(member);
		if(success) 
			conutil.printAddSuccessMessage(member);
		else
			conutil.printAddFailMessage(member);
		
	}

}
