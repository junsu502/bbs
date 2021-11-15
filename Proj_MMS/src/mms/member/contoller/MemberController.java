package mms.member.contoller;

import java.util.Scanner;

import mms.member.action.Action;
//컨트롤러 를 다시 컨트롤러
public class MemberController {
	public void processRequest(Action action,Scanner sc){
		
		try{
		action.execute(sc);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}	
}
