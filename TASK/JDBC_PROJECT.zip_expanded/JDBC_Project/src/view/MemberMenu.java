package view;

import java.util.List;
import java.util.Scanner;

import controller.MemberController;
import model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController controller = new MemberController();

	public void mainMenu() {
		while (true) {
			System.out.println("\n===== 회원 관리 메뉴 =====");
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 수정");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 전체 회원 조회");
			System.out.println("5. 회원 번호로 조회");
			System.out.println("0. 뒤로가기");
			System.out.print("선택: ");

			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1:
				insertMemberMenu();
				break;
			case 2:
				updateMemberMenu();
				break;
			case 3:
				deleteMemberMenu();
				break;
			case 4:
				selectAllMembers();
				break;
			case 5:
				selectMemberByNo();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void insertMemberMenu() {
		System.out.print("회원 ID: ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("이메일: ");
		String email = sc.nextLine();
		System.out.print("전화번호: ");
		String phone = sc.nextLine();

		Member m = new Member(memberId, password, name, email, phone);
		int result = controller.insertMember(m);
		System.out.println(result > 0 ? "회원 등록 성공" : "회원 등록 실패.");
	}

	private void updateMemberMenu() {
		System.out.print("수정할 회원 번호: ");
		int memberNo = sc.nextInt();
		sc.nextLine();
		System.out.print("회원 ID: ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("이메일: ");
		String email = sc.nextLine();
		System.out.print("전화번호: ");
		String phone = sc.nextLine();

		Member m = new Member(memberNo, memberId, password, name, email, phone, null);
		int result = controller.updateMember(m);
		System.out.println(result > 0 ? "회원 수정 성공" : "회원 수정 실패.");
	}

	private void deleteMemberMenu() {
		System.out.print("삭제할 회원 번호: ");
		int memberNo = sc.nextInt();
		sc.nextLine();
		int result = controller.deleteMember(memberNo);
		System.out.println(result > 0 ? "회원 삭제 성공" : "회원 삭제 실패.");
	}

	private void selectAllMembers() {
		List<Member> list = controller.selectAll();
		System.out.println("\n===== 전체 회원 조회 =====");
		for (Member m : list) {
			System.out.println(m);
		}
	}

	private void selectMemberByNo() {
		System.out.print("조회할 회원 번호: ");
		int memberNo = sc.nextInt();
		sc.nextLine();
		Member m = controller.selectByNo(memberNo);
		System.out.println(m != null ? m : "해당 회원 정보가 없습니다.");
	}
}
