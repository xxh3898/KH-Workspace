package review4;

import java.util.Scanner;

public class ShapeMenu {
	private Scanner sc = new Scanner(System.in);
	SquareController scr = new SquareController();
	TriangleController tc = new TriangleController();

	public void inputMenu() {
		while (true) {
			System.out.println("===== 도형 프로그램 =====");
			System.out.println("3. 삼각형");
			System.out.println("4. 사각형");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 3: {
				triangleMenu();
				break;
			}
			case 4: {
				squareMenu();
				break;
			}
			case 9: {
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			default: {
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
				break;
			}
			}
		}
	}

	public void triangleMenu() {
		while (true) {
			System.out.println("===== 삼각형 =====");
			System.out.println("1. 삼각형 면적");
			System.out.println("2. 삼각형 색칠");
			System.out.println("3. 삼각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1: {
				inputSize(3, sel);
				break;
			}
			case 2: {
				System.out.println("색을 입력하세요 : ");
				String color = sc.nextLine();
				tc.paintColor(color);
				System.out.println("색상이 변경되었습니다.");
				break;
			}
			case 3: {
				printInformation(3);
				break;
			}
			case 9: {
				System.out.println("메뉴로 돌아갑니다.");
				return;
			}
			default: {
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
				break;
			}
			}
		}

	}

	public void squareMenu() {

		while (true) {
			System.out.println("===== 사각형 =====");
			System.out.println("1. 사각형 면적");
			System.out.println("2. 사각형 둘레");
			System.out.println("3. 사각형 색칠");
			System.out.println("4. 사각형 정보");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1: {
				inputSize(4, sel);
				break;
			}
			case 2: {
				inputSize(4, sel);
				break;
			}
			case 3: {
				System.out.println("색을 입력하세요 : ");
				String color = sc.nextLine();
				scr.paintColor(color);
				System.out.println("색상이 변경되었습니다.");
				break;
			}
			case 4: {
				printInformation(4);
				break;
			}
			case 9: {
				System.out.println("메뉴로 돌아갑니다.");
				return;
			}
			default: {
				System.out.println("잘못된 번호입니다. 다시 입력하세요.");
				break;
			}
			}
		}
	}

	public void inputSize(int type, int menuNum) {
		System.out.println("높이를 입력하세요 : ");
		double height = sc.nextDouble();
		System.out.println("길이를 입력하세요 : ");
		double width = sc.nextDouble();
		if (type == 3) {
			double result = tc.calcArea(height, width);
			System.out.println("면적 : " + result);
		} else if (type == 4) {
			if (menuNum == 1) {
				double result = scr.calcArea(height, width);
				System.out.println("면적 : " + result);
			} else if (menuNum == 2) {
				double result = scr.calcPerimeter(height, width);
				System.out.println("둘레 : " + result);
			}
		}

	}

	public void printInformation(int type) {
		if (type == 3) {
			System.out.println("삼각형 " + tc.print());
		} else if (type == 4) {
			System.out.println("사각형 " + scr.print());
		}
	}
}
