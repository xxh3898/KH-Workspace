package array;

import java.util.Scanner;

public class ArrayPractice03 {
// N개의 바구니(1~N번)가 있고, M개의 공 넣기 작업이 주어집니다. 각 작업은 i번 바구니부터 j번 바구니까지 숫자 k가 적힌 공을 넣는 것을 의미합니다. 그 후 각 바구니에 어떤 공이 들어 있는지 출력하세요. 공이 없는 경우 0으로 출력합니다. 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("배열의 길이를 입력하세요 : ");
		int length=sc.nextInt();
		int arr[] =new int[length];
		int ball=0, start=0, end=0, time=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]=0;
	}
		System.out.print("몇 개의 공을 넣을지 입력하세요 : ");
		time=sc.nextInt();
		for(int i=1;i<=time;i++) {
			System.out.println("n번 바구니부터 n번바구니까지 n채우기");
			start=sc.nextInt();
			end=sc.nextInt();
			ball=sc.nextInt();
			for(int k=start-1;k<=end-1;k++) {
				arr[k]=ball;
			}
		}
		
		for(int num:arr) {
				System.out.print(num+" ");
		}
	}
}
