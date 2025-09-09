package com.kh.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * - Comparable : 객체 스스로 기본 정렬 기준 제공
 * - Comparator : 필요할 때 외부에서 정렬 기준 주입
 */
public class Run {
	public static void main(String[] args) {
		List<Student> list=new ArrayList<>();
		list.add(new Student("철수", 80, 18));
		list.add(new Student("지수", 100, 17));
		list.add(new Student("정수", 75, 16));
		list.add(new Student("영수", 64, 15));
		list.add(new Student("지수", 100, 19));
		
		System.out.println("최초 저장값");
		System.out.println(list);
		
		//Comparable  : 학생의 정의된 기준으로 정렬
		System.out.println("정렬후");
		Collections.sort(list);
		System.out.println();
	}

}
