package example.poly1;

import java.util.Scanner;

public class AnimalManager {
	    public static void main(String[] args) {
	        Animal[] animals = new Animal[5];

	        Scanner sc=new Scanner(System.in);
	        
	        for(int i=0;i<animals.length;i++) {
	        	System.out.println("1. 강아지 2. 고양이:");
	        	int num=sc.nextInt();
	        	
	        	System.out.println("이름 : ");
	        	String name=sc.next();
	        	
	        	System.out.println("나이 : ");
	        	int age=sc.nextInt();
	        	
	        	if(num==1) {
	        		System.out.println("견종 : ");
	        		String breed=sc.next();
	        		animals[i]=new Dog(name, age, breed);
	        	}else {
	        		System.out.println("색상 : ");
	        		String color=sc.next();
	        		animals[i]=new Cat(name, age, color);
	        	}
	        }

	        for (Animal a : animals) {
	            a.speak(); // 다형성 호출

	            if (a instanceof Dog) {
	                Dog d = (Dog) a;
	                System.out.println("이 개의 견종은 " + d.getBreed() + "입니다.");
	            } else if (a instanceof Cat) {
	                Cat c = (Cat) a;
	                System.out.println("이 고양이의 색상은 " + c.getColor() + "입니다.");
	            }}}}
	        
