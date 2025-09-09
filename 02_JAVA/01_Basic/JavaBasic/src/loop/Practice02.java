package loop;

import java.util.Scanner;

public class Practice02 {
/*
 * 영수증에 적힌 **총 구매 금액**이 실제 구매한 각 물건의 **가격 × 개수 합계**와 일치하는지 확인하는 프로그램을 작성하세요.

총액이 정확하면 `"Yes"`, 그렇지 않으면 `"No"`를 출력합니다.
 * */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int sum=0;
		int total_price=sc.nextInt();
		sc.nextLine();
		int count=sc.nextInt();
		sc.nextLine();
		for(int i=1;i<=count;i++) {
			int a=sc.nextInt();	// 물건의 가격
			int b=sc.nextInt(); // 물건의 구매 개수
			
			sum+=(a*b);
		}
//		if(sum==total_price) {
//			System.out.println("Yes");
//		}else {
//			System.out.println("No");
//		}
		System.out.println(sum==total_price?"Yes":"No");
	}

}
