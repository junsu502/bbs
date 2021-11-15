package mms.member.util;

import java.util.ArrayList;
import java.util.Scanner;
import mms.member.vo.Member;

public class ConsoleUtill {
	public Member getNewMember(Scanner sc) {
		
		Member member = new Member();
		System.out.print("이름: ");
		member.setName(sc.next());
		System.out.print("주소: ");
		member.setAddr(sc.next());
		System.out.print("국가: ");
		member.setNation(sc.next());
		System.out.print("이메일: ");
		member.setEmail(sc.next());
		System.out.print("나이: ");
		member.setAge(sc.nextInt());
		
		return member;
	}
	public void printAddSuccessMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 성공");
	}
	
	public void printAddFailMessage(Member newMember) {
		System.out.println(newMember.getName() + " 회원 정보 추가 실패");
	}

	public void printMemberList(ArrayList<Member> memberList) {
		//size() : 컬렉션에 저장되어 있는 요소의 개수를 리턴하는 메소드
		
		for(int i=0; i<memberList.size(); i++) {
			Member m= memberList.get(i);
			System.out.println("name= "+m.getName() + ", address= "+ m.getAddr()+ ", email= "+m.getAddr()+", nation= "+ m.getNation()+
						", age= " + m.getAge());
		}

	}

	public String getName(String msgKind, Scanner sc) {
		return msgKind;


	}

	public Member getUpdateMember(Scanner sc, Member oldMember) {
		return oldMember;	

		
	}

	public void printModifySuccessMessage(Member updateMember) {
		System.out.println(updateMember.getName() + " 회원 정보 수정 성공.");	
	}
	
	public void printModifyFailMessage(Member updateMember) {	
		System.out.println(updateMember.getName() + " 회원 정보 수정 실패.");	
	}

	public void printRemoveSuccessMessage(String name) {	
		System.out.println(name + " 회원의 정보 삭제 성공.");
	}

	public void printRemoveFailMessage(String name) {	
		System.out.println(name + " 회원의 정보 삭제 실패.");
	}	
}
