package example.polymorphism;

public class Avante extends Car{
	public Avante(String color, String fuel, int year) {
		super();
		this.color = color;
		this.fuel = fuel;
		this.year = year;
	}
	public void drive() {
		System.out.println("슝슝");
	}
	public void moveAvante() {
		System.out.println("붕 아반뗴");
	}
}
