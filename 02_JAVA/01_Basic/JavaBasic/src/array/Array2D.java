package array;

import java.util.Scanner;

public class Array2D {
	/*
	 * 2차원 배열
	 * 자료형이 같은 1차형 배열의 묶음
	 * ex) int[행][열] arr -> ~열의 1차원배열이 행만큼 존재
	 * 2차원 배열은 할당된 공간마다 index를 2개 부여(앞은 행: 몇번쨰 1차원 배열인지, 뒤는 열 : 1차원 배열의 개수)
	 * 
	 * 선언된 공간마다 같은 길이의 1차원 배열을 사용할 수도 있고
	 * 각각 다른 길이의 1차원 배열을 할당할 수도 있음
	 * */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// 2차원 배열 선언(1차원배열의 묶음을 참조하는 2차원배열 참조변수 선언
		int[][] arr;
		
		// 2차원배열의 메모리할당
		// 배열명=new자료형[n][m];
		arr=new int[2][3];
		arr[0][0] =5;
		arr[0][1] =10;
		arr[0][2] =15;
		arr[1][0] =1;
		arr[1][1] =2;
		arr[1][2] =3;
		
//		System.out.println(arr[0][0]);
		
		for(int j=0;j<arr.length;j++) {
			for(int i=0;i<arr[j].length;i++) {
				System.out.print(arr[j][i]+" ");
			}
			System.out.println();
		}
//		arr=new int[3][0];
	}

}
