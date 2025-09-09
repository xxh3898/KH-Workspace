package operator;

public class Operator3 {
	/*
	 * 산술연산자
	 * + - * / %
	 * 
	 * 복합대입연산자
	 * 산술연산자와 대입연산자를 결합해서 사용할 수 있다.
	 * 
	 * += /= -= %= *=
	 * 
	 * a = a%3;; -> a %= 3;
	 * */
	public static void main(String[] args) {
		int a=5;			// 6
		int b=10;			// 9
		int c=(++a)+b;		// 16
		int d=16/6;			// 1
		int e= c%a;			// 5
		int f=e++;			// 4
		int g=(--b)+(d--);	// 10
		int h=2;
		
		int i=(a++)+b/(--c/f)*(g-- -d)%(++e +h); 
		//		7  +9/(15/4)*(9 - 1)%8
		System.out.println(i);

	}

}
