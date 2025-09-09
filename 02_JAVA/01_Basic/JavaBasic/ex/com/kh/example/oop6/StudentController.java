package com.kh.example.oop6;
//- **필드**
//- `sArr : Student[] = new Student[5]` — 학생 정보 배열
//- `CUT_LINE : int = 60` — 합격 기준 점수
//- **생성자**
//- `StudentController()`
//    
//    → 5명의 학생 객체를 **샘플 데이터**로 초기화
//    
//    ```
//    김길동, 자바, 100
//    박길동, 디비, 50
//    이길동, 화면, 85
//    정길동, 서버, 60
//    홍길동, 자바, 20
//    ```
//    
//- **메서드**
//- `printStudent(): Student[]` — 학생 배열 반환
//- `sumScore(): int` — 모든 학생 점수 합계 반환
//- `avgScore(): double[]`
//    
//    → 크기 2의 `double` 배열 반환
//    
//    - [0] = 점수 합계
//    - [1] = 평균 (합계 / 학생 수)
public class StudentController {
	private Student[] sArr=new Student[5];
	private int CUT_LINE=60;
	
	public StudentController() {
		super();
	}
}
