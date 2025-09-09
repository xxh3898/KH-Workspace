package com.kh.example.gearrent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GearRentController {
	HashMap<String, Device> catalog;
	HashMap<String, Member> members;
	HashMap<String, Loan> activeLoans;
	
	public boolean addDevice(Device device) {
		//— 장비 등록; catalog에 같은 id가 없으면 추가하고 true, 이미 있으면 false를 반환.
	}
	
	public boolean addMember(Member member) {
		//— 회원 등록; members에 같은 id가 없으면 추가하고 true, 이미 있으면 false를 반환.
	}
	
	public Loan borrow(String memberId, String itemId, LocalDate today) {
		//대여 생성; 장비의 getBorrowLimitDays()로 기한을 계산해 Loan을 만들고 activeLoans에 저장, 장비 대여 수 증가 후 Loan을 반환.
	}
	
	public int returnItem(String itemId, LocalDate today) {
		//반납 처리; 대여 건의 반납일을 today로 기록하고 overdueDays(today)로 연체일을 구해(음수는 0이 되도록 구현됨)
		//장비의 calcLateFee(연체일)로 연체료를 계산, activeLoans에서 제거 후 연체료 int를 반환.
	}
	
	public ArrayList<Device> findByTag(String tag){
		//태그 검색; tag가 null이면 빈 리스트를 반환, catalog의 장비들을 훑어 hasTag(tag)가 참인 장비만 리스트에 담아 정렬 없이 그대로 반환.
	}
	
	public ArrayList<Device> findByKeyword(String keyword){
		//키워드 검색; keyword가 null이거나 빈 문자열이면 빈 리스트를 반환,
		//소문자로 통일해 이름 또는 카테고리에 포함되는 장비만 모아 정렬 없이 그대로 반환.
	}
	
	public Collection<Device> getAllDevices(){
		//전체 장비 조회; 입력 없음, catalog.values()의 읽기 전용 뷰를 반환해 외부 수정은 막고 순서는 보장하지 않음.
	}
	public Collection<Device> getActiveLoans(){
		//대여중 목록 조회; 입력 없음, activeLoans.values()의 읽기 전용 뷰를 반환해 외부 수정을 막고 순서는 보장하지 않음.
	}
}
