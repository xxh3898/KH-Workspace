package view;

import java.util.List;
import java.util.Scanner;
import controller.ScreenController;
import model.vo.Screen;

public class ScreenMenu {
	private Scanner sc = new Scanner(System.in);
	private ScreenController controller = new ScreenController();

	public void mainMenu() {
		while (true) {
			System.out.println("\n===== 상영관 관리 메뉴 =====");
			System.out.println("1. 상영관 등록");
			System.out.println("2. 상영관 수정");
			System.out.println("3. 상영관 삭제");
			System.out.println("4. 전체조회");
			System.out.println("5. ID조회");
			System.out.println("0. 이전 메뉴");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1:
				insertScreenMenu();
				break;
			case 2:
				updateScreenMenu();
				break;
			case 3:
				deleteScreenMenu();
				break;
			case 4:
				selectAllScreenMenu();
				break;
			case 5:
				selectByIdScreenMenu();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void insertScreenMenu() {
		System.out.print("상영관 이름: ");
		String name = sc.nextLine();
		System.out.print("좌석 수: ");
		int seatCount = sc.nextInt();
		sc.nextLine();
		Screen s = new Screen(0, name, seatCount);
		int result = controller.insertScreenExample(s);
		System.out.println(result > 0 ? "등록 성공" : "등록 실패");
	}

	private void updateScreenMenu() {
		System.out.print("수정할 상영관 ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("상영관 이름: ");
		String name = sc.nextLine();
		System.out.print("좌석 수: ");
		int seatCount = sc.nextInt();
		sc.nextLine();
		Screen s = new Screen(id, name, seatCount);
		int result = controller.updateScreenExample(s);
		System.out.println(result > 0 ? "수정 성공" : "수정 실패");
	}

	private void deleteScreenMenu() {
		System.out.print("삭제할 상영관 ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		int result = controller.deleteScreenExample(id);
		System.out.println(result > 0 ? "삭제 성공" : "삭제 실패");
	}

	private void selectAllScreenMenu() {
		List<Screen> list = controller.selectAllExample();
		for (Screen s : list)
			System.out.println(s);
	}

	private void selectByIdScreenMenu() {
		System.out.print("조회할 상영관 ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		Screen s = controller.selectByIdExample(id);
		System.out.println(s != null ? s : "상영관 정보 없음");
	}
}
