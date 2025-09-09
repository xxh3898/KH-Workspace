package loop;

import java.util.Scanner;

/*### 문제 설명

정수 `N(1 ≤ N ≤ 9)`이 주어졌을 때, **`N` 단 구구단을 1부터 9까지 출력**하는 프로그램을 작성하세요. 출력 형식은 `N * i = 결과`이며, 각 줄마다 i가 1부터 9까지 하나씩 증가합니다. 공백과 기호 표현에 주의하세요*/
public class Practice01 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("입력 : ");
		int dan=sc.nextInt();
		sc.nextLine();
		if(dan<=9 && dan>=1) {
		for(int i=1;i<=9;i++)
			System.out.printf("%d * %d = %d\n",dan,i,(dan*i));
		}else {
			System.out.println("2~9를 입력해주세요");
		}
		sc.close();
	}

}
