package method;

public class MethodLocalVariable {
	/*
	 * 지역변수
	 * -블룩 내부에서 선언된 변수
	 * -해당블록을 벗어나면 메모리에서 제거됨
	 * -선언시 반드시 초기화 후 사용해야함
	 * 
	 * 매개변수
	 * -메서드 호출시 외부에서 전달받는 값을 저장하는 지역변수
	 * -매서드 선언부에 정의됨
	 * -메서드 실행시 생성되고, 메서드 종료시 사라짐
	 * */
	public static void main(String[] args) {
		// main의 지역변수
		// main이 종료되면 사라짐
		String name="철수";
		int age=20;
		
		System.out.println("실행전 : "+name);
		say(name, age);
		System.out.println("실행 후 : "+name);
		if(name.equals("철수")) {
//			String name="지원"; 포함되는 관계는 같은 지역이므로 동일한 이름을 사용할 수 없음
		}
		// Call By Value(값에 의한 호출) -> 자바는 무조건 이 방식으로 호출
		// 메모리에 담긴 값 자체를 전달
		// 기본형 -> 값(데이터)자체가 복사됨
		// 참조형 -> 참조값(주소)이 복사됨
		// 			주소값을 복사해서 같은 객체를 가르기게 되므로 내부 데이터를 변경하면 원본에도 영향을 줌
		
		int num=10;
		// changeValue(num);
		
	}
	public static void say(String name, int age) {
		name="지원";
		System.out.println("내부 : "+name);
	}
}
