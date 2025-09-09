package com.kh.example.gearrent;

import java.time.LocalDate;

public class Loan {
	private String itemId;
	private String memberId;
	private LocalDate loanDate;
	private LocalDate dueDate;
	private LocalDate returnedDate;
	
	public Loan(String itemId, String memberId, LocalDate loanDate, LocalDate dueDate, LocalDate returnedDate) {
		this.itemId = itemId;
		this.memberId = memberId;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
		this.returnedDate = null;
	}
	
	public boolean isOverdue(LocalDate today) {
        LocalDate referenceDate = (returnedDate != null) ? returnedDate : today;
        return referenceDate.isAfter(dueDate);
    }
	
	public int overdueDays(LocalDate today) {
//		연체 일수를 계산, today(현재 날짜)를 입력받아 반납 완료면 반납일, 미반납이면 today를 기준으로,
//		기준 날짜가 기한을 넘겼다면 기준 날짜와 기한 사이의 경과 ‘일수’를 반환하고, 넘기지 않았다면 0을 반환.
	}

	@Override
	public String toString() {
		return "Loan[item="+itemId+", member="+memberId+", loan="+loanDate+", due="+dueDate+", ret="+(returnedDate != null ? returnedDate : "미반납");
	}
	
}
