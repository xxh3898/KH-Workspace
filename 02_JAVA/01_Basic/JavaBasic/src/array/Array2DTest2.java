package array;

import java.util.Scanner;

public class Array2DTest2 {

	public static void main(String[] args) {
	//		사용자에게 좌석의 행과 열을 입력받아 2차원 배열을 생성
	//		각 좌석에 들어갈 관객의 이름을 입력받아 저장한뒤
	//		좌석표를 출력
	//		행(줄)의 수 : 
	//		열(좌석)의 수 : 
	//		1행 1열 : 철수~
	//		1행 2열 : 민수~
	//		1행 3열 : 상수~
		Scanner sc=new Scanner(System.in);
		System.out.print("행(줄)의 수 :");
		int n=sc.nextInt();
		System.out.print("열(좌석)의 수 : ");
		int m=sc.nextInt();
		sc.nextLine();
		String[][] arr = new String[n][m];
		for(int i=0; i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%d행 %d열 : ",i+1,j+1);
				arr[i][j]=sc.nextLine();
			}
		}
			System.out.println("========좌석표========");

		for(int j=0;j<arr.length;j++) {
			for(int i=0;i<arr[j].length;i++) {
				System.out.print(arr[j][i]+" ");
			}
			System.out.println();
		}
	}

}
