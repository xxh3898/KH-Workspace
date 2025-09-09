package api;

import java.util.StringTokenizer;

public class StringAPI {
	public void method01() {
	//1. 생성자를 통한 문자열 생성
	String str1 =new String("hello");
	String str2 =new String("hello");
	
	System.out.println(str1);
	System.out.println(str2);
	// String 클래스에 toString메서드는 이미 오버라이딩 되어있음
	// 그래서 참조변수 출력시 Object의 toString형식(타입@주소값16진수)이 아니라 String의 저장된 문자열이 반환됨
		
	System.out.println(str1==str2);
	//String객체의 주소값을 비교하기 때무넹 false
	
	System.out.println(str1.equals(str2));
	//String 클래스에서는 dquals메서드도 이미 오버라이딩 되어있음(주소값비교가 아닌 문자열값을 비교하도록)
	
	System.out.println(str1.hashCode());
	System.out.println(str2.hashCode());
	//String클래스에서 hashCode메서드도 이미 오버라이딩 되어있음(주소값이 아닌 문자열을 가지고 해시값을 만들도록)
	
	String str4=str1.replace('l','c');
	System.out.println(str4);
	}
	
	public void method03() {
		String str="Java,Oracle,sql,html,css,js,spring";
		
		//구분자를 기준으로 문자열을 분리시키는 바업ㅂ
		//방법1. 분리된 문자열들을 String[]에 차곡차곡 담아야 할 때
		//String에서 제공하는 split메서드를 사용
		//문자열.split(구분자) : String[]
		String[] arr=str.split(",");
		for(String st:arr) {
			System.out.print(st+" ");
		}
	System.out.println();
		String str2=String.join("/", arr);
		System.out.println(str2);
		
		//방법2. 분리된 문자열들을 각각 토크으로서 관리 가능
		//문자열 토큰화 : StringTokenizer
		StringTokenizer stn =new StringTokenizer(str,",");
		System.out.println(stn.countTokens());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
		System.out.println(stn.nextToken());
//		System.out.println(stn.nextToken()); 더이상 토큰이 남아있지 않을 때 다음토큰 호출시 예외 발생
		
		int size =stn.countTokens();
		for(int i=0;i<size;i++) {
			System.out.println(stn.nextToken());
		}
	}
}
