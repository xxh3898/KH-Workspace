package array;

import java.util.Scanner;

public class ArrayPractice02 {
// N개의 정수가 주어질 때, 이들 중 최솟값과 최댓값을 찾는 프로그램을 작성하세요
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("배열의 길이를 입력하세요 : ");
		int lenth=sc.nextInt();
		int arr[] =new int[lenth];

		for(int i=0;i<arr.length;i++) {
			int num=sc.nextInt();
			arr[i]=num;
		}
		int max=arr[0];
		int min=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min+" "+max);
	}
}