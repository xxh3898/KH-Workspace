package array;

import java.util.Scanner;

public class ArrayPractice01 {
// 정수 N개로 이루어진 수열 A와 정수 X가 주어집니다. 이때, 수열 A에서 X보다 작은 수를 모두 입력된 순서대로 공백 한 칸으로 구분하여 출력하는 프로그램을 작성하세요. 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("배열의 길이를 입력하세요 : ");
		int lenth=sc.nextInt();
		System.out.print("배열의 최대값을 입력하세요 : ");
		int max=sc.nextInt();
		
		int arr[] =new int[lenth];
		
		for(int i=0;i<arr.length;i++) {
			int num=sc.nextInt();
			arr[i]=num;
		}
		for(int num:arr) {
			if(num<max) {
				System.out.print(num+" ");
			}
		}
	}

}
