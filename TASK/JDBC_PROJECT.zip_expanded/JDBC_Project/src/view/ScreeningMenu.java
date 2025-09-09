package view;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;
import controller.ScreeningController;
import model.vo.Screening;

public class ScreeningMenu {
	private Scanner sc = new Scanner(System.in);
	private ScreeningController controller = new ScreeningController();

	public void mainMenu() {
		while (true) {
			System.out.println("\n===== 상영 정보 관리 메뉴 =====");
			System.out.println("1. 상영 등록");
			System.out.println("2. 상영 수정");
			System.out.println("3. 상영 삭제");
			System.out.println("4. 전체조회");
			System.out.println("5. ID조회");
			System.out.println("0. 이전 메뉴");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1:
				insertScreeningMenu();
				break;
			case 2:
				updateScreeningMenu();
				break;
			case 3:
				deleteScreeningMenu();
				break;
			case 4:
				selectAllScreeningMenu();
				break;
			case 5:
				selectByIdScreeningMenu();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void insertScreeningMenu() {
		System.out.print("영화 ID: ");
		int movieId = sc.nextInt();
		sc.nextLine();
		System.out.print("상영관 이름: ");
		String name = sc.nextLine();
		System.out.print("상영 시간(yyyy-mm-dd hh:mm:ss): ");
		Timestamp screeningTime = Timestamp.valueOf(sc.nextLine());
		Screening s = new Screening(movieId, name, screeningTime);
		int result = controller.insertScreeningExample(s);
		System.out.println(result > 0 ? "등록 성공" : "등록 실패");
	}

	private void updateScreeningMenu() {
		System.out.print("수정할 상영 ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("영화 ID: ");
		int movieId = sc.nextInt();
		sc.nextLine();
		System.out.print("상영관 이름: ");
		String name = sc.nextLine();
		System.out.print("상영 시간(yyyy-mm-dd hh:mm:ss): ");
		Timestamp screeningTime = Timestamp.valueOf(sc.nextLine());
		Screening s = new Screening(id, movieId, null, name, screeningTime);
		int result = controller.updateScreeningExample(s);
		System.out.println(result > 0 ? "수정 성공" : "수정 실패");
	}

	private void deleteScreeningMenu() {
		System.out.print("삭제할 상영 ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		int result = controller.deleteScreeningExample(id);
		System.out.println(result > 0 ? "삭제 성공" : "삭제 실패");
	}

	private void selectAllScreeningMenu() {
		List<Screening> list = controller.selectAllExample();
		if (list.isEmpty()) {
			System.out.println("상영 정보가 없습니다.");
			return;
		}
		for (Screening s : list)
			System.out.println(s);
	}

	private void selectByIdScreeningMenu() {
		System.out.print("조회할 상영 ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		Screening s = controller.selectByIdExample(id);
		System.out.println(s != null ? s : "상영 정보 없음");
	}
}
