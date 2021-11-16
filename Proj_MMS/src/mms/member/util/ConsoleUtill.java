package mms.member.util;
//사용자 입력, 출력
import java.util.ArrayList;
import java.util.Scanner;

import mms.member.svc.MemberModifyService;
import mms.member.vo.Member;

public class ConsoleUtill {
//	1.회원등록
	public Member getNewMember(Scanner sc) {
		System.out.println("등록할 회원 정보를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("주소 : ");
		String addr = sc.next();
		System.out.print("국가 : ");
		String nation = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		Member member = new Member(name, addr, nation, email, age);
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
		System.out.println(memberList.get(i));
		}

	}

	public String getName(String ename,Scanner sc) {
		System.out.println("수정할 회원이름을 입력하세요.");
		System.out.println("회원이름 : ");
		String name = sc.next();
		return name;
	}

	public Member getUpdateMember(Scanner sc, Member oldMember) {
		System.out.println("이전국가 : "+ oldMember.getNation());
		System.out.println("수정할 국가 : ");
		String nation = sc.next();
		
		System.out.println("이전주소 : "+ oldMember.getAddr());
		System.out.println("수정할 주소 : ");
		String addr = sc.next();
		
		System.out.println("이전 이메일 : "+ oldMember.getEmail());
		System.out.println("수정할 국가 : ");
		String email = sc.next();
		
		System.out.println("이전나이 : "+ oldMember.getAge());
		System.out.println("수정할 국가 : ");
		int age = sc.nextInt();
		
		
		return new Member(oldMember.getName(), addr, nation, email, age);
		
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
