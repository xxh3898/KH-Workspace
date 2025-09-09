package com.kh.example.oop6.copy;

public class StudentController {
	Student[] sArr = new Student[5];
	public static int CUT_LINE = 60;

	public StudentController() {
		sArr[0] = new Student("김길동", "자바", 100);
		sArr[1] = new Student("박길동", "디비", 50);
		sArr[2] = new Student("이길동", "화면", 85);
		sArr[3] = new Student("정길동", "서버", 60);
		sArr[4] = new Student("홍길동", "자바", 20);
	}

//	- **메서드**
//    - `printStudent(): Student[]` — 학생 배열 반환
//    - `sumScore(): int` — 모든 학생 점수 합계 반환
//    - `avgScore(): double[]`
//        
//        → 크기 2의 `double` 배열 반환
//        
//        - [0] = 점수 합계
//        - [1] = 평균 (합계 / 학생 수)

	public Student[] printStudent() {
		return sArr;
	}

	public int sumScore() {
		int sum = 0;
		for (Student s : sArr) {
			sum += s.getScore();
		}
		return sum;
	}

	public double[] avgScore() {
		int sum = 0;
		for (Student s : sArr) {
			sum += s.getScore();
		}
		double avg = (double) sum / 5;
		return new double[] { sum, avg };
	}
}
