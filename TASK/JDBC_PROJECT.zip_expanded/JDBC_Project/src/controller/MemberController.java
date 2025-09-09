package controller;

import service.MemberService;
import model.vo.Member;

import java.util.List;

public class MemberController {
	private MemberService service = new MemberService();

	// 회원 등록
	public int insertMember(Member m) {
		return service.insertMember(m);
	}

	// 회원 수정
	public int updateMember(Member m) {
		return service.updateMember(m);
	}

	// 회원 삭제
	public int deleteMember(int memberNo) {
		return service.deleteMember(memberNo);
	}

	// 전체 회원 조회
	public List<Member> selectAll() {
		return service.selectAll();
	}

	// 회원 번호로 조회
	public Member selectByNo(int memberNo) {
		return service.selectByNo(memberNo);
	}

	// 로그인 기능
	public Member login(String memberId, String password) {
		return service.login(memberId, password);
	}
}
