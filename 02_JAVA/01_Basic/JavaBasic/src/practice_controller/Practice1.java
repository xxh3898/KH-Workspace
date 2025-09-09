package practice_controller;

import java.util.Scanner;

/*
	문제1 : 시험 성적 출력 프로그램
	문제 설명
	0점부터 100점 사이의 정수를 입력받아 아래 조건에 따라 등급(학점)을 출력하는 프로그램을 작성하세요.
	입력 조건
	시험 점수 (정수형, 0 이상 100 이하)
	성적 기준표
	점수 범위
	등급
	90 ~ 100
	A
	80 ~ 89
	B
	70 ~ 79
	C
	60 ~ 69
	D
	0 ~ 59
	F
 * */
public class Practice1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int score;
		System.out.println("점수를 입력하세요 : ");
		score=sc.nextInt();
		if(score>=0 && score<60) {
			System.out.println("F");
		}else if(score>=60&&score<70) {
			System.out.println("D");
		}else if(score>=70&&score<80) {
			System.out.println("C");
		}else if(score>=80&&score<90) {
			System.out.println("B");
		}else{
			System.out.println("A");
		}
		sc.close();
	}

}
