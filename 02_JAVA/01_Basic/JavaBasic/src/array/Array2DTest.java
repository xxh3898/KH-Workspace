package array;

import java.util.Scanner;

public class Array2DTest {

	public static void main(String[] args) {
		//사용자에게 행과 열을 입력받아
		//해당 행과열의 빙고판을 만들어라
		//다음행과 열의 들어갈 문자를 각각 모두 입력받아 저장한 뒤 출력
		Scanner sc=new Scanner(System.in);
		System.out.println("행을 입력하세요 : ");
		int n=sc.nextInt();
		System.out.println("열을 입력하세요 : ");
		int m=sc.nextInt();
		sc.nextLine();
		String[][] arr = new String[n][m];
		for(int i=0; i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%d행 %d열\n",i+1,j+1);
				arr[i][j]=sc.nextLine();
			}
			System.out.println();
		}

		for(int j=0;j<arr.length;j++) {
			for(int i=0;i<arr[j].length;i++) {
				System.out.print(arr[j][i]+" ");
			}
			System.out.println();
		}
	}

}
