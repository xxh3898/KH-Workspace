package poly1;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] animals = new Animal[5];
		animals[0] = new Dog("바둑이", 3, "진돗개");
		animals[1] = new Cat("나비", 2, "흰색");
		animals[2] = new Dog("초코", 1, "푸들");
		animals[3] = new Cat("하양이", 4, "검은색");
		animals[4] = new Dog("흰둥이", 5, "말티즈");

		for (Animal a : animals) {
			if(a instanceof Dog) {
				Dog dog=(Dog)a;
				a.speak();
				System.out.println("이 개의 견종은 "+dog.getBreed()+"입니다.");
			}else {
				Cat cat=(Cat)a;
				a.speak();
			System.out.println("이 고양이의 색상은 "+cat.getColor()+"입니다.");
			}
		}
	}

}
