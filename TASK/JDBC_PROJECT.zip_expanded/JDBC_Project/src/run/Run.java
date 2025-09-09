package run;

import java.util.Scanner;

import view.AdminMenu;
import view.UserMenu;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserMenu userMenu = new UserMenu();
		AdminMenu adminMenu = new AdminMenu();

		while (true) {
			System.out.println("\n=====  영화 예매 시스템 =====");
			System.out.println("1. 로그인 / 회원가입");
			System.out.println("2. 관리자 로그인");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 : ");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1: {
				userMenu.mainMenu();
				break;
			}
			case 2: {
				adminMenu.mainMenu();
				break;
			}
			case 0: {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			default: {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			}
		}
	}
}
