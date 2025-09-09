package array;

import java.util.Scanner;

public class ArrayPractice05 {
// 1번부터 N번까지 번호가 순서대로 적힌 바구니가 있습니다. M개의 뒤집기 작업이 주어지며, 각각은 i번부터 j번 바구니의 순서를 역순으로 바꾸는 작업입니다. 모든 작업 후 최종 바구니의 번호 배열을 출력하세요.
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("배열의 길이를 입력하세요 : ");
		int length=sc.nextInt();
		int arr[] =new int[length];
		int ball=0, start=0, end=0, time=0;
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
	}
		System.out.print("몇 번 뒤집을지 입력하세요 : ");
		time=sc.nextInt();
		for(int i=1;i<=time;i++) {
			System.out.println("n번 바구니부터 n번바구니까지 n채우기");
			start=sc.nextInt();
			end=sc.nextInt();
			int left = start - 1;
            int right = end - 1;
			for(int k=start-1;k<=end-1;k++) {
				while (left < right) {
	                int temp = arr[left];
	                arr[left] = arr[right];
	                arr[right] = temp;
	                left++;
	                right--;
	            }
			}
		}
		
		for(int num:arr) {
				System.out.print(num+" ");
		}
	}
}
