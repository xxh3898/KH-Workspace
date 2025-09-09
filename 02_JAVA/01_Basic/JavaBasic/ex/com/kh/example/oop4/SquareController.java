package com.kh.example.oop4;
//- `calcPerimeter(double height, double width)` : `double`
//
//→ `s`를 매개변수 있는 생성자로 초기화한 후, **둘레**(`width*2 + height*2`) 반환
//
//- `calcArea(double height, double width)` : `double`
//
//→ `s`를 매개변수 있는 생성자로 초기화한 후, **넓이**(`width * height`) 반환
//
//- `paintColor(String color)` : `void`
//
//→ `s`의 색상을 setter로 변경
//
//- `print()` : `String`
//
//→ `"사각형 " + s.information()` 반환
public class SquareController {
	private Shape s=new Shape();
	
	
	public double calcPerimeter(double height, double width) {
		s=new Shape(4, height, width); //TODO 타입 알 수 없음
		return s.getWidth()*2+s.getHeight()*2;
	}
	
	public double calcArea(double height, double width) {
		s=new Shape(4, height, width);
		return width * height;
	}
	
	public void paintColor(String color) {
		s.setColor(color);
	}
	
	public String print() {
		return "사각형 " + s.information();
	}
}
