package loop_05;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		while (true) {
			System.out.print("숫자 입력 : ");
			int a = sc.nextInt();
			if (a > 0) {
				sum += a;
			} else {
				break;
			}
		}
		System.out.println(sum);
	}
}
