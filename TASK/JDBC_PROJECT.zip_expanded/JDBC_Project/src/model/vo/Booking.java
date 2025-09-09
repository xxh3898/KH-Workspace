package model.vo;

import java.sql.Timestamp;

public class Booking {
	private int bookingId;
	private int memberNo; // 회원번호(DB 기준)
	private String memberId; // 선택적, 로그인용 ID
	private int screeningId;
	private int seatNumber;
	private Timestamp bookingDate;

	// 조회용
	public Booking(int bookingId, int memberNo, String memberId, int screeningId, int seatNumber,
			Timestamp bookingDate) {
		this.bookingId = bookingId;
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.screeningId = screeningId;
		this.seatNumber = seatNumber;
		this.bookingDate = bookingDate;
	}

	// 등록용 (회원번호 기반)
	public Booking(int memberNo, int screeningId, int seatNumber) {
		this.memberNo = memberNo;
		this.screeningId = screeningId;
		this.seatNumber = seatNumber;
	}

	// 수정용 생성자
	public Booking(int bookingId, int memberNo, int screeningId, int seatNumber) {
		this.bookingId = bookingId;
		this.memberNo = memberNo;
		this.screeningId = screeningId;
		this.seatNumber = seatNumber;
	}

	// getter & setter
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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

	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Timestamp getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "예매번호: " + bookingId + " / 회원No :" + memberNo + " / 상영관 :" + screeningId + "번 / 좌석 번호 : " + seatNumber
				+ " / 예약일 : " + bookingDate;
	}
}