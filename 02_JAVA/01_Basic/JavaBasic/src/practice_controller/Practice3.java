package practice_controller;

import java.util.Scanner;

/*
	 * ## 문제3 : 놀이공원 입장권 계산기

---

### 문제 설명

어린이, 청소년, 성인의 구분에 따라 입장료가 다르게 부과되는 **놀이공원 요금 계산기**를 만들어보세요.

또한, 주말에는 20% 할인이 적용됩니다.

---

### 입력 조건

- 나이 (int)
- 요일 (문자열: "월", "화", ..., "일")

---

### 요금표

| 구분 | 나이 범위 | 기본 요금 |
| --- | --- | --- |
| 어린이 | 0 ~ 12세 | 5,000원 |
| 청소년 | 13 ~ 18세 | 7,000원 |
| 성인 | 19세 이상 | 10,000원 |

---

### 할인 조건

- 요일이 `"토"` 또는 `"일"`인 경우, **입장료의 20% 할인**
	 * */
public class Practice3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int age=0, price=0;
		String day;
		String grade="";
		System.out.println("나이를 입력하세요 : ");
		age=sc.nextInt();
		sc.nextLine();
		System.out.println("요일을 입력하세요 : ");
		day=sc.nextLine();
		
		if(age>=0&&age<=12) {
			grade="어린이";
			price=5000;
		}else if(age>=13&&age<=18) {
			grade="청소년";
			price=7000;
		}else if(age>=19) {
			grade="성인";
			price=10000;
		}
		if(day.equals("토") || day.equals("일")) {
			price = (int)(price * 0.8);
			System.out.printf("%s요금입니다.(주말 할인 적용)\n", grade);
		}else {
			System.out.printf("%s요금입니다.\n", grade);
		}
		System.out.printf("최종 요금은 %d원입니다.\n", price);
		sc.close();
	}

}
