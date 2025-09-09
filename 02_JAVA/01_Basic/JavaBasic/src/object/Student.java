package object;
/*
 *	//생성자영역
 *	: 데이터를 초기화
 */
public class Student {
	//필드
	String name;
	int age;
	double height;
	
	//메서드
	//내 정보를 출력하는 기능
	void myInfo() {
		System.out.printf("안녕하세요. 저는 %d살의 %s입니다.",age, name);
	}
}