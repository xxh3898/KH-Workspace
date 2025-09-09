package com.kh.example.oop4;
//- **필드**
//- `type` : `int` → 도형 타입 번호 (예: 3 = 삼각형, 4 = 사각형)
//- `height` : `double` → 높이
//- `width` : `double` → 너비
//- `color` : `String` → 색상 (기본값 `"white"`)
//- **생성자**
//- `Shape()` → 기본 생성자
//- `Shape(int type, double height, double width)` → 필드 초기화 생성자
//- **메서드**
//- getter/setter 메서드 직접 구현
//- `information()` : `String` → `"높이 너비 색상"` 형식의 문자열 반환
public class Shape {
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	private int type;
	private double height;
	private double width;
	private String color="white";
	
	public Shape() {
		super();
	}
	
	public Shape(int type, double height, double width) {
		
        this.type = type;
        this.height = height;
        this.width = width;
        this.color = "white";
    }
	
	public String information() {
	        return height + " " + width + " " + color;
	    }
}
