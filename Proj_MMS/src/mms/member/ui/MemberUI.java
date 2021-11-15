package mms.member.ui;

import java.util.Scanner;

import mms.member.contoller.MemberController;

public class MemberUI {
	public static void main(String[] args) {
		boolean isStop = false;
		MemberController memberController = new MemberController();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("=====회원관리 프로그램=====");
			System.out.println("1.회원등록");
			System.out.println("2.회원목록보기");
			System.out.println("3.회원정보수정");
			System.out.println("4.회원정보삭제");
			System.out.println("5.프로그램 종료");
			System.out.print("메뉴번호: ");
			int a =sc.nextInt();
			switch(a) {
			case 1:
				System.out.println("등록할 회원 정보를 입력하세요.");
				
			}
			
			
			
			
			
			
			
		}while(!isStop);
		
		
	}
}
