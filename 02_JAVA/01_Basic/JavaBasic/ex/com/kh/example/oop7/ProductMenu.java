package com.kh.example.oop7;

import java.util.Scanner;

public class ProductMenu {
	private ProductController pc = new ProductController();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		while (true) {
			System.out.println("====== 상품 관리 메뉴 ======");
			System.out.println("1. 상품 추가");
			System.out.println("2. 상품 전체 조회");
			System.out.println("3. 상품 제거");
			System.out.println("4. 상품 검색");
			System.out.println("5. 상품가격 수정");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴 번호 : ");

			int select = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (select) {

			case 1:
				System.out.println("추가할 상품명 : ");
				String pName = sc.nextLine();
				System.out.println("추가할 가격 : ");
				int price = sc.nextInt();
				System.out.println("추가할 브랜드 : ");
				String brand = sc.next();
				sc.nextLine();

				pc.insertProduct(pName, price, brand);
				break;
			case 2:
				Product[] pro = pc.selectProduct();
				for (Product p : pro) {
					if (p == null)
						break;
					System.out.println(p.inform());
				}
				System.out.println();
				break;
			case 3: {
				pc.deleteProduct();
				break;
			}
			case 4: {
				System.out.print("검색할 키워드를 입력하세요 : ");
				String key = sc.next();
				pc.searchProduct(key);

				break;
			}
			case 5: {
				updateProductPrice();

				break;
			}
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
	}

	private void updateProductPrice() {
		// 상품명과 수정할 가격을 입력 받아 해당 상품의 가격을 수정한다.
		System.out.print("검색할 상품명을 입력하세요 : ");
		String pName = sc.nextLine();
		System.out.print("수정할 금액을 입력하세요 : ");
		int price = sc.nextInt();
		sc.nextLine();
		pc.updateProductPrice(pName, price);
	}

}
