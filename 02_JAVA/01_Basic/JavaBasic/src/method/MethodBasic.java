package method;

public class MethodBasic {
	/*
	 * 메서드란
	 * -class 내부에 정의된 함수(Function)를 메서드(Method)라고 부름
	 * -특정 기능을 수행하는 코드블록을 정의하고, 필요할 때 호출하여 재사용 가능
	 * -중복코드 제거와 가독성, 유지보스 향상
	 * 
	 * [기본구조]
	 * 
	 * [접근제한자] [static] 반환형 메서드이름(매개변수){
	 * 		// 함수에서 실행할 코드
	 * 		[return 값]; 반환형이 void라면 return을 생략하거나 return;로 메서드 종료 가능
	 * 	}
	 * */
	// main메서드 : 프로그램의 시작을 의미하는 메서드
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		hiEveryone(25);
		System.out.println(adder(1,4));
		square(2);
		System.out.println("프로그램 끝");
	}
	public static void  hiEveryone(int age) {
		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는 "+age+"입니다.");
	}
	public static int adder(int num1, int num2) {
		int result=num1+num2;
		return result;
	}
	public static double square(double num) {
		return(num*num);
	}
}
