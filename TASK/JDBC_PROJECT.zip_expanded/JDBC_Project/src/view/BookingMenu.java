package view;

import java.util.List;
import java.util.Scanner;

import controller.BookingController;
import controller.MovieController;
import model.vo.Booking;
import model.vo.Member;
import model.vo.Movie;
import model.vo.Screening;

public class BookingMenu {
	private Scanner sc = new Scanner(System.in);
	private BookingController controller = new BookingController();
	private MovieController movieController = new MovieController(); // 영화 조회용
	private Member loginMember; // 로그인된 회원 정보 저장

	public void setLoginMember(Member loginMember) {
		this.loginMember = loginMember;
	}

	public void userMenu() {
		while (true) {
			System.out.println("\n===== 예매 메뉴 =====");
			System.out.println("1. 예매하기");
			System.out.println("2. 내 예매 확인");
			System.out.println("0. 뒤로가기");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1:
				insertBookingMenu();
				break;
			case 2:
				checkMyBookings();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public void adminMenu() {
		while (true) {
			System.out.println("\n===== 예매 관리 메뉴 =====");
			System.out.println("1. 예매 등록");
			System.out.println("2. 예매 수정");
			System.out.println("3. 예매 삭제");
			System.out.println("4. 전체 예매 조회");
			System.out.println("5. 예매번호 조회");
			System.out.println("0. 뒤로가기");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1:
				insertBookingMenu();
				break;
			case 2:
				updateBookingMenu();
				break;
			case 3:
				deleteBookingMenu();
				break;
			case 4:
				selectAllBookingMenu();
				break;
			case 5:
				selectByIdBookingMenu();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void insertBookingMenu() {
		int memberNo;
		MovieMenu movieMenu = new MovieMenu();
		movieMenu.selectAllMovieMenu();

		if (loginMember != null) {
			memberNo = loginMember.getMemberNo();
			System.out.println("\n회원 ID: " + loginMember.getMemberId());
		} else {
			System.out.print("회원 번호 입력: ");
			memberNo = sc.nextInt();
			sc.nextLine();
		}

		System.out.print("MovieNo 선택: ");
		int screeningId = sc.nextInt();
		sc.nextLine();

		Screening screening = controller.getScreeningById(screeningId);
		if (screening == null) {
			System.out.println("잘못된 상영번호입니다. 다시 선택해주세요.");
			return;
		}
		System.out.print("좌석 번호: ");
		int seatNumber = sc.nextInt();
		sc.nextLine();

		Booking b = new Booking(memberNo, screeningId, seatNumber);
		int result = controller.insertBookingExample(b);
		System.out.println(result > 0 ? "예매 등록 성공" : "예매 등록 실패");
	}

	private void updateBookingMenu() {
		System.out.print("수정할 예매번호: ");
		int bookingId = sc.nextInt();
		sc.nextLine();

		int memberNo;
		if (loginMember != null) {
			memberNo = loginMember.getMemberNo();
			System.out.println("\n회원 ID: " + loginMember.getMemberId());
		} else {
			System.out.print("회원 번호 입력: ");
			memberNo = sc.nextInt();
			sc.nextLine();
		}

		System.out.print("상영 ID: ");
		int screeningId = sc.nextInt();
		sc.nextLine();
		System.out.print("좌석 번호: ");
		int seatNumber = sc.nextInt();
		sc.nextLine();

		Booking b = new Booking(bookingId, memberNo, screeningId, seatNumber);
		int result = controller.updateBookingExample(b);
		System.out.println(result > 0 ? "예매 수정 성공" : "예매 수정 실패");
	}

	private void deleteBookingMenu() {
		System.out.print("삭제할 예매번호: ");
		int bookingId = sc.nextInt();
		sc.nextLine();
		int result = controller.deleteBookingExample(bookingId);
		System.out.println(result > 0 ? "예매 삭제 성공" : "예매 삭제 실패");
	}

	private void selectAllBookingMenu() {
		List<Booking> list = controller.selectAllExample();
		System.out.println("\n===== 전체 예매 정보 =====");
		for (Booking b : list) {
			Movie movie = movieController.selectByIdExample(b.getScreeningId());
			System.out.println("예매번호 :" + b.getBookingId() + " / 회원No :" + b.getMemberNo() + " / 영화제목 :"
					+ (movie != null ? movie.getTitle() : "정보 없음") + " / 상영관 :" + b.getScreeningId() + "번"
					+ " / 좌석 번호 : " + b.getSeatNumber() + " / 예약일 : " + b.getBookingDate());
		}
	}

	private void selectByIdBookingMenu() {
		System.out.print("조회할 예매번호: ");
		int bookingId = sc.nextInt();
		sc.nextLine();
		Booking b = controller.selectByIdExample(bookingId);
		if (b != null) {
			Movie movie = movieController.selectByIdExample(b.getScreeningId());
			System.out.println("예매번호 :" + b.getBookingId() + " / 회원No :" + b.getMemberNo() + " / 영화제목 :"
					+ (movie != null ? movie.getTitle() : "정보 없음") + " / 상영관 :" + b.getScreeningId() + "번"
					+ " / 좌석 번호 : " + b.getSeatNumber() + " / 예약일 : " + b.getBookingDate());
		} else {
			System.out.println("해당 예매 정보가 없습니다.");
		}
	}

	public void checkMyBookings() {
		if (loginMember == null) {
			System.out.println("로그인이 필요합니다.");
			return;
		}

		int memberNo = loginMember.getMemberNo();
		List<Booking> list = controller.selectAllExample();
		System.out.println("\n===== 내 예매 내역 =====");
		for (Booking b : list) {
			if (b.getMemberNo() == memberNo) {
				Movie movie = movieController.selectByIdExample(b.getScreeningId());
				System.out.println("예매번호 :" + b.getBookingId() + " / 영화제목 :"
						+ (movie != null ? movie.getTitle() : "정보 없음") + " / 상영관 :" + b.getScreeningId() + "번"
						+ " / 좌석 번호 : " + b.getSeatNumber() + " / 예약일 : " + b.getBookingDate());
			}
		}
	}
}