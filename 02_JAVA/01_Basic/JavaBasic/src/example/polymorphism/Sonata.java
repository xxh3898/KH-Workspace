package example.polymorphism;

public class Sonata extends Car{
	public Sonata(String color, String fuel, int year) {
		super();
		this.color = color;
		this.fuel = fuel;
		this.year = year;
	}
	public void moveSonata() {
		System.out.println("빵빵 sonata");
	}
}
