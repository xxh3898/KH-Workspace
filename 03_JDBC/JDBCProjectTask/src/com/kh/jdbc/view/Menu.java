package com.kh.jdbc.view;

import com.kh.jdbc.controller.Controller;
import com.kh.jdbc.vo.Order;
import com.kh.jdbc.vo.OrderItem;
import com.kh.jdbc.vo.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private Controller controller = new Controller();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		while (true) {
			System.out.println("\n===== 카페 키오스크 =====");
			System.out.println("1. 전체 상품 조회");
			System.out.println("2. 카테고리별 조회");
			System.out.println("3. 주문하기");
			System.out.println("4. 관리자");
			System.out.println("0. 종료");
			System.out.print("선택: ");

			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				displayProducts(controller.getAllProducts());
				break;
			case "2":
				displayByCategory();
				break;
			case "3":
				order();
				break;
			case "4":
				admin();
				break;
			case "0":
				return;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
	}

	private void displayProducts(List<Product> products) {
		System.out.printf("%-3s %-15s %-10s %-7s %-5s %-3s\n", "ID", "이름", "카테고리", "가격", "재고", "품절");
		System.out.println("----------------------------------------------------");
		for (Product p : products) {
			System.out.printf("%-3d %-15s %-10s %-7d %-5d %-3s\n", p.getProductId(), p.getName(), p.getCategory(),
					p.getPrice(), p.getStock(), p.isSoldOut() ? "O" : "X");
		}
	}

	private void displayByCategory() {
		List<String> categories = controller.getCategories();
		for (int i = 0; i < categories.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, categories.get(i));
		}
		System.out.print("카테고리 선택: ");
		int idx = Integer.parseInt(sc.nextLine()) - 1;
		if (idx < 0 || idx >= categories.size())
			return;
		List<Product> products = controller.getProductsByCategory(categories.get(idx));
		displayProducts(products);
	}

	private void order() {
		List<OrderItem> items = new ArrayList<>();
		while (true) {
			System.out.print("상품 ID 선택 (종료:0): ");
			int id = Integer.parseInt(sc.nextLine());
			if (id == 0)
				break;
			System.out.print("수량: ");
			int qty = Integer.parseInt(sc.nextLine());
			int price = controller.getProductById(id).getPrice(); // 가격 포함
			items.add(new OrderItem(id, qty, price));
		}
		if (items.isEmpty())
			return;
		Order order = new Order(items);
		if (controller.placeOrder(order))
			System.out.println("주문 완료!");
		else
			System.out.println("주문 실패!");
	}

	private void admin() {
		System.out.print("관리자 비밀번호: ");
		String pw = sc.nextLine();
		if (!"admin123".equals(pw)) {
			System.out.println("비밀번호 틀림!");
			return;
		}

		while (true) {
			System.out.println("\n===== 관리자 모드 =====");
			System.out.println("1. 전체 상품 조회");
			System.out.println("2. 재고 추가/감소");
			System.out.println("0. 관리자 종료");
			System.out.print("선택: ");

			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				displayProducts(controller.getAllProducts());
				break;
			case "2":
				updateStock();
				break;
			case "0":
				return;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}
	}

	private void updateStock() {
		List<Product> products = controller.getAllProducts();
		displayProducts(products);
		System.out.print("상품 ID 선택: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("증가(+) 또는 감소(-) 수량 입력: ");
		int qtyChange = Integer.parseInt(sc.nextLine());
		if (controller.updateStock(id, qtyChange))
			System.out.println("재고 업데이트 완료!");
		else
			System.out.println("재고 업데이트 실패!");
	}
}
