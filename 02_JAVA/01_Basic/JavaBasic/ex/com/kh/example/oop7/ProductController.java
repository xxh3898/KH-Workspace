package com.kh.example.oop7;

public class ProductController {

	private Product[] pro = new Product[10];

	public ProductController() {
		pro[0] = new Product("갤럭시", 1200000, "삼성");
		pro[1] = new Product("아이폰", 1300000, "애플");
		pro[2] = new Product("아이패드", 800000, "애플");
	}

	public void insertProduct(String pName, int price, String brand) {
		for (int i = 0; i < pro.length; i++) {
			if (pro[i] == null) {
				pro[i] = new Product(pName, price, brand);
				return;
			}
		}
	}

	public Product[] selectProduct() {
		return pro;
	}

	public void deleteProduct() {

		for (int i = 0; i < pro.length; i++) {
			if (pro[i + 1] == null) {
				pro[i] = null;
				break;
			} else if (i == 9) {
				pro[9] = null;
				break;
			}
			// pro[9]
		}
		System.out.println("마지막 제품이 삭제되었습니다.");
	}

	public void searchProduct(String key) {
		// 배열 돌면서 pName에 key 들어있는지 찾기 getpName으로
		for (int i = 0; i < pro.length; i++) {
			if (pro[i] != null && pro[i].getpName().contains(key)) {
				System.out.println("검색 결과: " + pro[i].inform());
				return;
			}
		}
	System.out.println("검색 결과가 없습니다.");
	
	}

	public void updateProductPrice(String pName, int price) {
		for (int i = 0; i < pro.length; i++) {
			if (pro[i] != null && pro[i].getpName().equals(pName)) {
				pro[i].setPrice(price);
				System.out.println("수정 결과: " + pro[i].inform());
				return;
			}
		}
	System.out.println("검색 결과가 없습니다.");
		}
}