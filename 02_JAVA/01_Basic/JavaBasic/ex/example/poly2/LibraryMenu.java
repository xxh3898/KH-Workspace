package example.poly2;

import java.util.Scanner;

public class LibraryMenu {
	private LibraryController lc = new LibraryController();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		System.out.println("이름 :");
		String name = sc.next();

		System.out.println("나이 :");
		int age = sc.nextInt();

		System.out.println("성별 : ");
		char gender = sc.next().charAt(0);

		lc.insertMember(new Member(name, age, gender)); // 생성자 문제 해결 필요

		while (true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("5. 도서 삭제하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");

			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				Member m = lc.myInfo();
				if (m != null)
					System.out.println(m);
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 5:
				deleteBook();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

	private void deleteBook() {
		//도서정보를 전체출력한후  인덱스를 입력받아 도서목록에서 해당 인덱스의 값을 제거한 후 도서목록에 생성된개ㄱ체딱 맞게 배여을 다시 생성해서 교체
	}

	public void selectAll() {
		Book[] bookArr = lc.selectAll();
		for (int i = 0; i < bookArr.length; i++) {
			if (bookArr[i] == null)
				break;
			System.out.printf("%d번 도서 : %s\n", i, bookArr[i]); // bookArr[i] 출력
		}
	}

	public void searchBook() {
		System.out.println("검색할 제목 키워드 : ");
		String keyword = sc.next();
		sc.nextLine();

		Book[] searchList = lc.searchBook(keyword);
		if (searchList[0] == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for (Book bk : searchList) {
				if (bk == null)
					break;
				System.out.println(bk);
			}
		}
	}

	public void rentBook() {
		selectAll();
		System.out.println("대여할 도서번호 선택: ");
		int index = sc.nextInt();
		sc.nextLine();

		int result = lc.rentBook(index);
		switch (result) {
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이제한으로 대여 불가합니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요.");
			break;
		default:
			System.out.println("대여가 불가능한 책입니다.");
		}
	}
}
