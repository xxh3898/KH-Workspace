package com.kh.option;
/*
 * 접근제한자 : 클래스, 필드, 메서드등 구성 요소의 접근 범위를 제한하는 키워드
 * 			불필요하거나 위험한 접근을 막아 데이터 무결성과 보안을 유지
 * public > protected > default > private
 * 
 * public : 어디서든 접근 가능
 * protected : 같은 패키지 + 상솩관계인 경우 접근 가능
 * default : 같은 패키지 내에서 접근 가능
 * private : 오직 해당 클래스에서만 접근 가능
 */
public class Book {
	private String title;
	private String genre;
	private String author;
	private int maxPage;
	
	public Book() {
		
	}
}
