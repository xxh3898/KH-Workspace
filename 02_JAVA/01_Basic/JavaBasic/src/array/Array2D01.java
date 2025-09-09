package array;

import java.util.Scanner;

public class Array2D01 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("행");
		int n=sc.nextInt();
		System.out.println("열");
		int m=sc.nextInt();
		int [][] arr1=new int[n][m];
		int [][] arr2=new int[n][m];
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				arr1[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				arr2[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				int result=arr1[i][j]+arr2[i][j];
				System.out.print(result+" ");
			}
				System.out.println();
		}
	}

}
