package model.vo;

public class Screen {
	private int screenNo;
	private String name;
	private int seatCount;

	// 조회용
	public Screen(int screenNo, String name, int seatCount) {
		this.screenNo = screenNo;
		this.name = name;
		this.seatCount = seatCount;
	}

	// 등록용
	public Screen(String name, int seatCount) {
		this.name = name;
		this.seatCount = seatCount;
	}

	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	@Override
	public String toString() {
		return "상영관 ID : " + screenNo + " / 상영관 : " + name + " / 좌석 수 : " + seatCount;
	}
}
