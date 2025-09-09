package loop_06;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		while (true) {
			System.out.print("숫자 입력 : ");
			int a = sc.nextInt();
			if (a % 2 == 0) {
				System.out.println("짝수 " + a + "의 제곱은 " + a * a + "입니다.");
			} else {
				continue;
			}
		}
	}
}
