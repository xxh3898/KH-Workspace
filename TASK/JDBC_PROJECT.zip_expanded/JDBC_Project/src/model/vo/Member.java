package model.vo;

import java.sql.Date;

public class Member {
	private int memberNo; // PK
	private String memberId; // 로그인용 ID
	private String password; // 로그인용 PW
	private String name;
	private String email;
	private String phone;
	private Date joinDate;

	// 생성자: 조회용
	public Member(int memberNo, String memberId, String password, String name, String email, String phone,
			Date joinDate) {
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.joinDate = joinDate;
	}

	// 생성자: 등록용 (memberNo는 시퀀스로 자동 생성, joinDate는 DB SYSDATE)
	public Member(String memberId, String password, String name, String email, String phone) {
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "회원No : " + memberNo + " / ID : " + memberId + " / 이름 : " + name + " / 이메일 : " + email + " / 전화번호 : "
				+ phone + " / 가입일 : " + joinDate;
	}
}
