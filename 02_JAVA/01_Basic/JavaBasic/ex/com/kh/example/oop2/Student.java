package com.kh.example.oop2;

public class Student {
	private int grade;

	{
		grade=3;
		classroom=3;
		name="조치호";
		height=30;
		gender='남';
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String information() {
		return grade+"학년"+classroom+"반"+name+"/"+height+"cm"+gender;
	}
	private int classroom;
	private String name;
	private double height;
	private char gender;
	
}
