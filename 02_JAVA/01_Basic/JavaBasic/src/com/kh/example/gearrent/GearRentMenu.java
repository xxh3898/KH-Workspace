package com.kh.example.gearrent;

import java.util.Scanner;

public class GearRentMenu {
	private GearRentController gc=new GearRentController();
	private Scanner sc=new Scanner(System.in);
	
	public void mainMenu() {
//		- 메인 메뉴를 반복해서 보여주고 사용자가 선택한 번호에 따라 장비등록→회원등록→대여→반납→태그검색→키워드검색→전체장비→대여중목록 기능으로 분기하며,
//		종료를 선택하면 메서드를 빠져나온다. 번호가 잘못 입력되면 “잘못 입력하였습니다. 다시 입력해주세요” 메시지를 출력하고 메뉴를 다시 보여준다.
		while(true) {
			System.out.println("=== KH 장비 대여 관리 ===");
			System.out.println("1. 장비등록");
			System.out.println("2. 회원등록");
			System.out.println("3. 대여");
			System.out.println("4. 반납");
			System.out.println("5. 태그검색");
			System.out.println("6. 키워드검색");
			System.out.println("7. 전체검색");
			System.out.println("8. 대여중목록");
			System.out.println("9. 종료");
			System.out.print("메뉴 : ");
			
			int sel=sc.nextInt();
			
			switch(sel) {
			case 1:{addDevice();break;}
			case 2:{addMember();break;}
			case 3:{borrow();break;}
			case 4:{returnItem();break;}
			case 5:{findByTag();break;}
			case 6:{findByKeyword();break;}
			case 7:{printAllDevices();break;}
			case 8:{printActiveLoans();break;}
			case 9:{System.out.println("프로그램을 종료합니다.");return;}
			default:{System.out.println("잘못 입력하였습니다. 다시 입력해주세요");break;}
			}
			System.out.println();
		}
	}

	public void addDevice() {
//		유형(1: Camera, 2: Laptop)과 id/name/category/tags를 차례대로 입력받아 tags는 쉼표로 분리해 공백을 제거한 뒤 중복 없는 Set으로 만들고,
//		선택한 유형의 장비 객체를 생성해 gc.addDevice(...)로 등록을 시도한다. 등록이 성공하면 “등록 완료”를, 이미 같은 id가 있으면 “중복된 ID입니다. 다시 입력해주세요.”를 출력한다
	}
	
	public void addMember() {
//		- 회원 id와 이름을 입력받아 gc.addMember(...)를 호출해 등록을 시도하고, 성공 여부에 따라 가입 완료 또는 중복 안내 메시지를 출력한다.	
	}

	public void borrow(){
//		- memberId, itemId, 대여일(YYYY-MM-DD)을 입력받아 gc.borrow(...)로 대여를 생성하고, 성공하면 생성된 Loan 정보와 계산된 반납 예정일(dueDate)을 함께 출력한다.
//		회원/장비가 없거나 이미 대여 중 등 예외 상황이면 그 사유를 메시지로 알려준다.
	
	}

	public void returnItem() {
//		- itemId와 반납일(YYYY-MM-DD)을 입력받아 gc.returnItem(...)으로 반납을 처리하고, 계산된 연체료 금액을 “반납 완료. 연체료: {fee}원” 형식으로 출력한다.
//		해당 itemId의 대여 건이 없으면 오류 메시지를 안내한다.	
	}

	public void findByTag() {
//		- 검색할 태그 문자열을 입력받아 gc.findByTag(tag) 결과 목록을 그대로 출력한다. 결과가 없으면 “결과 없음” 등 안내 문구를 보여준다.		
	}
	public void findByKeyword() {
//		- 키워드를 입력받아 이름(name) 또는 카테고리(category)에 해당 키워드가 포함된 장비들을 gc.findByKeyword(keyword)로 조회해 그대로 출력한다.	
	}

	public void printAllDevices() {
//		- gc.getAllDevices()로 읽기 전용 컬렉션을 받아 현재 저장된 순서대로 모든 장비를 순회 출력한다	
	}

	public void printActiveLoans() {
//		- gc.getActiveLoans()로 읽기 전용 컬렉션을 받아 현재 대여 중인 모든 Loan을 순회 출력한다	
	}
}
