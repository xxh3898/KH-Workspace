package array;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		// 1. 크기가 10인 정수형 배열생성
		int[] arr=new int[10];
		
		// 2. 반복문을 통해서 0번 인덱스부터 마지막 인덱스까지 10으로 초기화
		for(int i=0;i<arr.length;i++) {
			arr[i]= 10;
		}
		
		// 3. for-each를 통해 모든 배열의 요소를 출력
		for(int num:arr) {
			System.out.print(num+" ");
		}
		System.out.println();
		
		// 4. 사용자에게 배열의 길이를 입력받아, 해당크기의 문자열 배열 nameArr 생성
		Scanner sc=new Scanner(System.in);
		System.out.println("배열의 길이 입력 : ");
		int size=sc.nextInt();
		String[]nameArr=new String[size];
		
		// 5. 사용자에게 사람의 이름을 입력받아 nameArr에 할당, nameArr의 모든 요소만큼 실행
		for(int i=0;i<nameArr.length;i++) {
			System.out.println("이름 입력 : ");
			nameArr[i]= sc.next();
		}
		
		// 6. 사용자에게 이름을 하나 입력받아, nameArr에 동일한 이름이 있다면 동일한 이름이 존재합니다. / 동일한 이름이 존재하지 않습니다. 출력
//		String nameIn=sc.next();
//		for(String n:nameArr) {
//			if(nameIn.equals(n)){
//				System.out.println("동일한 이름이 존재합니다.");
//				break;
//			}
//				System.out.println("동일한 이름이 존재하지 않습니다.");
//			
//		}
//	
		String nameIn = sc.next();
		int i;

		for (i = 0; i < nameArr.length; i++) {
		    if (nameIn.equals(nameArr[i])) {
		        System.out.println("동일한 이름이 존재합니다.");
		        break;
		    }
		}

		if (i == nameArr.length) {
		    System.out.println("동일한 이름이 존재하지 않습니다.");
		}

	}
}
