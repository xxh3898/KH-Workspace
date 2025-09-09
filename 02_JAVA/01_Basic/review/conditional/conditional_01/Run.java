package conditional_01;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int score;

		// 점수 입력 + 검증 루프
		while (true) {
			System.out.print("점수를 입력하세요 : ");
			score = sc.nextInt();

			if (score < 0 || score > 100) {
				System.out.println("점수는 0~100 사이의 정수만 입력 가능합니다.\n");
			} else {
				break; // 올바른 입력이면 반복 종료
			}
		}

		// 학점 계산
		String grade;
		if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}

		System.out.println("당신의 성적은 " + grade + "입니다.\n");

		sc.close();
	}
}
