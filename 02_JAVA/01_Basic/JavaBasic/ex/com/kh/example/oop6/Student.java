package com.kh.example.oop6;
//- **필드**
//- `name : String` — 이름
//- `subject : String` — 과목
//- `score : int` — 점수
//- **생성자**
//- `Student()` — 기본 생성자
//- `Student(String name, String subject, int score)` — 필드 초기화 생성자
//- **메서드**
//- 각 필드별 **getter / setter** 직접 구현
//- `inform(): String`
//    
//    → `"이름 : {이름} / 과목 : {과목} / 점수 : {점수}"` 형태의 문자열 반환
public class Student {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	private String name;
	private String subject;
	private int score;

public Student() {
	super();	
	}
public Student(String name, String subject, int score) {
	this.name = name;
	this.subject = subject;
	this.score = score;

}
public String inform() {
	return "이름 : " + name + " / 과목 : " + subject + " / 점수 : " + score;
}
}
