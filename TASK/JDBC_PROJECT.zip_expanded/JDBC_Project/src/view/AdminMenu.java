package view;

import java.util.Scanner;

public class AdminMenu {
	private Scanner sc = new Scanner(System.in);

	private UserMenu userMenu = new UserMenu();
	private MovieMenu movieMenu = new MovieMenu();
	private ScreenMenu screenMenu = new ScreenMenu();
	private ScreeningMenu screeningMenu = new ScreeningMenu();
	private BookingMenu bookingMenu = new BookingMenu();
	private MemberMenu memberMenu = new MemberMenu();

	public void mainMenu() {
		while (true) {
			System.out.println("\n===== 관리자 메뉴 =====");
			System.out.println("1. 영화 관리");
			System.out.println("2. 회원 관리");
			System.out.println("3. 상영관 관리");
			System.out.println("4. 상영 관리");
			System.out.println("5. 예매 관리");
			System.out.println("0. 뒤로가기");
			System.out.print("선택: ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch (sel) {
			case 1:
				movieMenu.mainMenu();
				break;
			case 2:
				memberMenu.mainMenu();
				break;
			case 3:
				screenMenu.mainMenu();
				break;
			case 4:
				screeningMenu.mainMenu();
				break;
			case 5:
				bookingMenu.adminMenu();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못 입력했습니다.");
			}
		}
	}
}
