package loop_02;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int total=sc.nextInt();
//		sc.nextLine();
		int count=sc.nextInt();
//		sc.nextLine();
		int sum=0;
		for(int i=0;i<count;i++) {
			int a=sc.nextInt();
//			sc.nextLine();
			int b=sc.nextInt();
//			sc.nextLine();
			sum+=(a*b);
		}
		System.out.println(total==sum);
	}
}
