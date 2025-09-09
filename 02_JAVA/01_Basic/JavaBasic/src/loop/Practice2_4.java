package loop;

public class Practice2_4 {
// `2단부터 9단까지`의 **구구단 전체를 출력**하는 프로그램을 작성하세요. 각 단마다 `2 * 1 = 2` 형식으로 1부터 9까지 곱한 값을 출력합니다.
	public static void main(String[] args) {
		int dan=2;
		for(int i=2;i<=9;i++) {
			for(int t=1;t<=9;t++) {
				System.out.printf("%d * %d = %d\n",dan,t,dan*t);
			}
			dan++;
			System.out.println("");
		}
	}

}
