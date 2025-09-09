package example.polymorphism;

public class Run {

	public static void main(String[] args) {
	/*
	 * 		클래스 참조변수			=		new 클래스 생성자();
	 * 	(부모클래스가 위치할 수 있음)	=	(자식클래스가 위치할 수 있음)	-> 업캐스팅
	 * 실제로 어디까지 접근이 가능한가	=	실제로 어떤 형태의 메모리가 생성되는가	
	 */
		/*
		Cake c1=new CheeseCake();
		// Cake까지 접근 가능하며 메모리공간은 실제 CheeseCake의 공간까지 존재함
		c1.sweet();
		// 오버라이딩시에는 실제 메모리에 있는 재정의된 메서드가 호출됨
		c1.yummy();
		// 다운캐스팅 : 자식의 참조변수로 타입을 변경(업캐스팅관계에 있을 경우에만 가능)
		((CheeseCake)c1).milky();
		
		// CheeseCake c2 = new Cake();
		// 실제 메모리가 Cake이므로 CheeseCake공간에 접근할 수 없음
		// -> 접근범위가 실제 메모리의 크기보다 클 수 없음
		 */
		
		
		// 1. 부모타입의 래퍼런스(잠조변수)로 부모객체를 다루는 경우
		Car c1=new Car("발강", "가솔린", 2021);
		c1.drive();
		Avante c2=new Avante("하양","lpg", 2022);
		c2.drive();
	}
}
