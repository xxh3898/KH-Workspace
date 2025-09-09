package example.ingerit;

import java.util.Scanner;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();

	public void mainMenu() {
		while (true) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");

			int select = sc.nextInt();
			sc.nextLine();

			switch (select) {
				case 1:
					circleMenu();
					break;
				case 2:
					rectangleMenu();
					break;
				case 9:
					System.out.println("종료합니다.");
					return;
				default:
					System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			}
		}
	}

	public void circleMenu() {
		while (true) {
			System.out.println("===== 원 메뉴 =====");
			System.out.println("1. 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");

			int select = sc.nextInt();
			sc.nextLine();

			switch (select) {
				case 1:
					calcCircleCircum();
					break;
				case 2:
					calcCircleArea();
					break;
				case 9:
					System.out.println("메인 메뉴로 돌아갑니다.");
					return;
				default:
					System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			}
		}
	}

	public void rectangleMenu() {
		while (true) {
			System.out.println("===== 사각형 메뉴 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");

			int select = sc.nextInt();
			sc.nextLine();

			switch (select) {
				case 1:
					calcRectanglePerimeter();
					break;
				case 2:
					calcRectangleArea();
					break;
				case 9:
					System.out.println("메인 메뉴로 돌아갑니다.");
					return;
				default:
					System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			}
		}
	}

	public void calcCircleCircum() {
		System.out.print("x좌표 : ");
		int x = sc.nextInt();
		System.out.print("y좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int r = sc.nextInt();
		sc.nextLine();

		String info = cc.calcCircum(x, y, r);
		System.out.println("둘레 : " + info);
	}

	public void calcCircleArea() {
		System.out.print("x좌표 : ");
		int x = sc.nextInt();
		System.out.print("y좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int r = sc.nextInt();
		sc.nextLine();

		String info = cc.calcArea(x, y, r);
		System.out.println("면적 : " + info);
	}

	public void calcRectanglePerimeter() {
		System.out.print("x좌표 : ");
		int x = sc.nextInt();
		System.out.print("y좌표 : ");
		int y = sc.nextInt();
		System.out.print("너비 : ");
		int w = sc.nextInt();
		System.out.print("높이 : ");
		int h = sc.nextInt();
		sc.nextLine();

		String info = rc.calcPerimeter(x, y, h, w);
		System.out.println("둘레 : " + info);
	}

	public void calcRectangleArea() {
		System.out.print("x좌표 : ");
		int x = sc.nextInt();
		System.out.print("y좌표 : ");
		int y = sc.nextInt();
		System.out.print("너비 : ");
		int w = sc.nextInt();
		System.out.print("높이 : ");
		int h = sc.nextInt();
		sc.nextLine();

		String info = rc.calcArea(x, y, h, w);
		System.out.println("면적 : " + info);
	}
}
