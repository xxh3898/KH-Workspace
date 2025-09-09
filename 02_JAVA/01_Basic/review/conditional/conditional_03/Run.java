package conditional_03;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("요일을 입력하세요 : ");
		String day = sc.nextLine();
		String grade;
		double price;
		if (age >= 19) {
			grade = "성인";
			price = 10000;
		} else if (age >= 13) {
			grade = "청소년";
			price = 7000;
		} else {
			grade = "어린이";
			price = 5000;
		}
		boolean isWekend = (day.equals("토") || day.equals("일"));
		if (isWekend) {
			price = price * 0.8;
		}
		System.out.println(grade + "요금입니다." + (isWekend ? "(주말 할인 적용)" : "") + "\n최종요급은 " + (int) price + "원 입니다.");
	}
}
