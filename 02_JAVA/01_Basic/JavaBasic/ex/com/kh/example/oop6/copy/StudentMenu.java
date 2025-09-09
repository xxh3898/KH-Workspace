package com.kh.example.oop6.copy;

public class StudentMenu {
	StudentController ssm = new StudentController();
	public static int CUT_LINE = 60;

	StudentMenu() {
		System.out.println("==========학생 정보 출력==========");
		for (Student s : ssm.printStudent()) {
			System.out.println(s.inform());
		}
		System.out.println("==========학생 성적 출력==========");
		double[] scoreData = ssm.avgScore();
		System.out.println("점수 합계 : " + scoreData[0]);
		System.out.println("평균 : " + scoreData[1]);

		System.out.println("==========성적 결과==========");
		for (Student s : ssm.printStudent()) {
			String result = s.getScore() < CUT_LINE ? "재시험 대상" : "통과";
			System.out.println(s.inform() + " → " + result);
		}
	}
}