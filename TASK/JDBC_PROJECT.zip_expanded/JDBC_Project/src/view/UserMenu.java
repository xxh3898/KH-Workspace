package view;

import java.util.Scanner;
import controller.MemberController;
import model.vo.Member;

public class UserMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController controller = new MemberController();
	private Member loginMember = null;

	public void mainMenu() {
		while (true) {
			if (loginMember == null) {
				showLoginMenu();
			} else {
				showUserMenu();
			}
		}
	}

	private void showLoginMenu() {
		System.out.println("\n===== 사용자 화면 =====");
		System.out.println("1. 로그인");
		System.out.println("2. 회원 가입");
		System.out.println("0. 종료");
		System.out.print("선택: ");
		int sel = sc.nextInt();
		sc.nextLine();

		switch (sel) {
		case 1:
			loginMenu();
			break;
		case 2:
			registerMenu();
			break;
		case 0:
			System.exit(0);
		default:
			System.out.println("잘못된 입력입니다.");
		}
	}

	private void showUserMenu() {
		System.out.println("\n===== 사용자 메뉴 =====");
		System.out.println("1. 영화 목록 조회");
		System.out.println("2. 예매 / 예매 확인");
		System.out.println("3. 내 정보 조회");
		System.out.println("4. 로그아웃");
		System.out.print("선택: ");
		int sel = sc.nextInt();
		sc.nextLine();

		switch (sel) {
		case 1:
			MovieMenu movieMenu = new MovieMenu();
			movieMenu.selectAllMovieMenu();
			break;
		case 2:
			BookingMenu bookingMenu = new BookingMenu();
			bookingMenu.setLoginMember(loginMember); // 로그인 회원 전달
			bookingMenu.userMenu();
			break;

		case 3:
			System.out.println("===== 내 정보 =====");
			System.out.println(loginMember);
			break;
		case 4:
			loginMember = null;
			System.out.println("로그아웃 되었습니다.");
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
	}

	private void loginMenu() {
		System.out.print("회원 ID: ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호: ");
		String password = sc.nextLine();

		loginMember = controller.login(memberId, password);
		if (loginMember != null)
			System.out.println("환영합니다, " + loginMember.getName() + "님.");
		else
			System.out.println("로그인 실패. ID 또는 비밀번호를 확인하세요.");
	}

	private void registerMenu() {
		System.out.print("회원 ID: ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("이메일: ");
		String email = sc.nextLine();
		System.out.print("전화번호: ");
		String phone = sc.nextLine();

		Member m = new Member(memberId, password, name, email, phone);
		int result = controller.insertMember(m);
		System.out.println(result > 0 ? "회원가입 성공" : "회원가입 실패");
	}
}
