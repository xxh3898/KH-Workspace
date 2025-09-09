package practice_controller;

import java.util.Scanner;

/*
	 * ## 주사위 세 개

---

### 문제 설명

1부터 6까지 눈이 있는 세 개의 주사위를 던졌을 때, 아래 규칙에 따라 상금을 계산하는 프로그램을 작성하세요.

---

### 입력 조건

- 한 줄에 세 개의 정수 (각각 주사위 눈, 1 ~ 6) 공백으로 구분하여 입력

---

### 상금 계산 규칙

| 경우 | 구체 조건 | 상금 계산식 |
| --- | --- | --- |
| 1 | 같은 눈이 **세 개 모두 같을 때** | 10,000원 + (같은 눈) × 1,000원 |
| 2 | 같은 눈이 **두 개만 같을 때** | 1,000원 + (같은 눈) × 100원 |
| 3 | 모두 다른 눈일 때 | (최댓값) × 100원 |

예:

- 예시 입력 `3 3 6` → 두 개만 같음 → `1,000 + 3×100 = 1,300원`
- 예시 입력 `2 2 2` → 모두 같음 → `10,000 + 2×1,000 = 12,000원`
- 예시 입력 `6 2 5` → 모두 다름 → `6×100 = 600원`
	 * */
public class Practice2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num1, num2, num3, result;
		System.out.println("입력 : ");
		num1=sc.nextInt();
		num2=sc.nextInt();
		num3=sc.nextInt();
		
		if(num1==num2&&num1==num3) {
			result=10000+(num1*1000);
		}else if(num1==num2) {
			result=1000+(num1*100);
		}else if(num1==num3) {
			result=1000+(num1*100);
		}else if(num2==num3) {
			result=1000+(num2*100);
		}else {
			int max = Math.max(num1, Math.max(num2, num3));
			// int max = num1>num2 ? num1:num2;
			//		max= max>num3?max:num3;
        result = max * 100;

		}
		System.out.println("출력 : "+result);
		sc.close();
	}

}
