package view;

import java.util.List;
import java.util.Scanner;
import controller.MovieController;
import model.vo.Movie;

public class MovieMenu {
	private Scanner sc = new Scanner(System.in);
	private MovieController controller = new MovieController();

	public void mainMenu() {
		while (true) {
			System.out.println("\n===== 영화 관리 메뉴 =====");
			System.out.println("1. 영화 등록");
			System.out.println("2. 영화 수정");
			System.out.println("3. 영화 삭제");
			System.out.println("4. 전체 조회");
			System.out.println("5. ID 조회");
			System.out.println("0. 이전 메뉴");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1:
				insertMovieMenu();
				break;
			case 2:
				updateMovieMenu();
				break;
			case 3:
				deleteMovieMenu();
				break;
			case 4:
				selectAllMovieMenu();
				break;
			case 5:
				selectByIdMovieMenu();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void insertMovieMenu() {
		System.out.print("영화 제목: ");
		String title = sc.nextLine();
		System.out.print("장르: ");
		String genre = sc.nextLine();
		System.out.print("감독: ");
		String director = sc.nextLine();
		System.out.print("상영 시간(분): ");
		int runtime = sc.nextInt();
		sc.nextLine();
		Movie m = new Movie(0, title, genre, director, runtime);
		int result = controller.insertMovieExample(m);
		System.out.println(result > 0 ? "영화 등록 성공" : "영화 등록 실패");
	}

	private void updateMovieMenu() {
		System.out.print("수정할 영화 ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("영화 제목: ");
		String title = sc.nextLine();
		System.out.print("장르: ");
		String genre = sc.nextLine();
		System.out.print("감독: ");
		String director = sc.nextLine();
		System.out.print("상영 시간(분): ");
		int runtime = sc.nextInt();
		sc.nextLine();
		Movie m = new Movie(id, title, genre, director, runtime);
		int result = controller.updateMovieExample(m);
		System.out.println(result > 0 ? "영화 수정 성공" : "영화 수정 실패");
	}

	private void deleteMovieMenu() {
		System.out.print("삭제할 영화 ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		int result = controller.deleteMovieExample(id);
		System.out.println(result > 0 ? "삭제 성공" : "삭제 실패");
	}

	void selectAllMovieMenu() {
		System.out.println("===== 상영중인 영화 목록 =====");
		List<Movie> list = controller.selectAllExample();
		for (Movie m : list)
			System.out.println(m);
	}

	private void selectByIdMovieMenu() {
		System.out.print("조회할 영화 ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		Movie m = controller.selectByIdExample(id);
		System.out.println(m != null ? m : "영화 정보 없음");
	}

}
