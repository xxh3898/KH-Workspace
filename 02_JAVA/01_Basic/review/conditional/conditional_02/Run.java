package conditional_02;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("#입력 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int sum;
		if (a == b && a == c) {
			sum = 10000 + a * 1000;
		} else if (a == b || a == c) {
			sum = 1000 + a * 100;
		} else if (b == a || b == c) {
			sum = 1000 + b * 100;
		} else if (c == b || a == c) {
			sum = 1000 + c * 100;
		} else {
			int max = a;
			if (b > max) {
				max = b;
			}
			if (c > max) {
				max = c;
			}
			sum = max * 100;
		}
		System.out.println("#출력 : " + sum);
	}
}
