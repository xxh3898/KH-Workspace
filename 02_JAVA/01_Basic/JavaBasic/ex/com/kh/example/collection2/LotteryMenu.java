package com.kh.example.collection2;

import java.util.HashSet;
import java.util.Scanner;

public class LotteryMenu {
	private Scanner sc=new Scanner(System.in);
	private LotteryController lc=new LotteryController();
	public void mainMenu() {
		while(true) {
		System.out.println("========== KH 추첨 프로그램 ==========");
		System.out.println("=====***** 메인 메뉴 *****=====");
		System.out.println("1. 추첨 대상 추가");
		System.out.println("2. 추첨 대상 삭제");
		System.out.println("3. 당첨 대상 확인");
		System.out.println("4. 정렬된 당첨 대상 확인");
		System.out.println("5. 당첨 대상 검색");
		System.out.println("9. 종료");
		System.out.println("메뉴 번호 입력 : ");
		
		int sel=sc.nextInt();
		
		switch(sel) {
			case 1: insertObject(); break;
			case 2: deleteObject(); break;
			case 3: winObject(); break;
//			case 4: sortedWinObject(); break;
			case 5: searchWinner(); break;
			case 9: System.out.println("프로그램 종료"); return;
			default: System.out.println("잘못입력하셨습니다.");
		}
		System.out.println();
	}
	}
	
	public void insertObject() {
        // 추가할 명수 입력 → 루프
        //   이름/번호 입력 → new Lottery(name, phone)
        //   lc.insertObject() 호출
        //   중복이면 "중복된 대상입니다. 다시 입력하세요." 후 같은 인덱스 재시도
        // 모두 완료 시 "추가 완료되었습니다."
		
		System.out.println("추가할 추첨 대상 수 : ");
		int num=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<num;i++) {
			System.out.println("이름 : ");
			String name=sc.nextLine();
			System.out.println("팬드폰 번호('-'뺴고) : ");
			String phone=sc.nextLine();
			boolean isInsert=lc.insertObject(new Lottery(name, phone));
			if(!isInsert) {
				System.out.println("중복된 인원입니다. 다시 입력해주세요.");
				i--;
			}
		}
		System.out.println(num+"명 추가 완료되었습니다.");
    }

    public void deleteObject() {
        // 이름/번호 입력 → lc.deleteObject()
        // true: "삭제 완료되었습니다."
        // false: "존재하지 않는 대상입니다."
    	System.out.println("삭제할 대상의 이름과 핸드폰 번호를 입력하세요.");
    	System.out.println("이름 : ");
		String name=sc.nextLine();
		System.out.println("팬드폰 번호('-'뺴고) : ");
		String phone=sc.nextLine();
		
		boolean isRemove=lc.deleteObject(new Lottery(name, phone));
		if(!isRemove) {
			System.out.println("삭제 완료되었습니다.");
		}else {
			System.out.println("존재하지 않는 대상입니다.");
		}
    }

    public void winObject() {
        // lc.winObject() 반환 Set을 println으로 출력
    	HashSet<Lottery> win =lc.winObject();
    	System.out.println(win);
    }

//    public void sortedWinObject() {
//        // lc.sortedWinObject() 반환 TreeSet을 Iterator로 순회 출력
//    }

    public void searchWinner() {
        // 이름/번호 입력 → lc.searchWinner()
        // true: "축하합니다. 당첨 목록에 존재합니다."
        // false: "안타깝지만 당첨 목록에 존재하지 않습니다."
    	System.out.println("검색할 대상의 이름과 핸드폰 번호를 입력하세요.");
    	System.out.println("이름 : ");
		String name=sc.nextLine();
		System.out.println("팬드폰 번호('-'뺴고) : ");
		String phone=sc.nextLine();
		
		boolean isWin=lc.searchWinner(new Lottery(name, phone));
		if(isWin) {
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		}else {
			System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다.");
		}
		
    }
}
