package object;
/*
 * 해당클래스는 객체를 생성하기 위함이 아닌
 * 실행을 위한 main문을 포함한 클래스
 */

////객체를 생성할 때
////class명 객체이름; -> 해당 class타입의 참조변수 생성
//Student choi;
////객체이름 =new class명() -> 새로운 class타입의 메모리 공간을 할당
//choi=new Student();
//Student kim=new Student();
//choi.name="최지원";
//choi.age=55;
//choi.myInfo();
//System.out.println(choi);
public class Run {

	public static void main(String[] args) {
		BankAccount ac1=new BankAccount();
		BankAccount ac2=ac1;
		
		ac1.depsit(5000);
		ac2.withdraw(1000);
		ac1.checkMyBalance();
		
		ac2=new BankAccount();
		ac2.depsit(2000);
		ac1.transfer(ac2, 1000);
		ac1.checkMyBalance();
		ac2.checkMyBalance();
	}

}
