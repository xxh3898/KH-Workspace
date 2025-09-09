package com.kh.example.collection2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

//LotteryController
public class LotteryController {
 private final HashSet<Lottery> lottery = new HashSet<>();
 private HashSet<Lottery> win = new HashSet<>();

 public boolean insertObject(Lottery l) {
	 /* lottery.add(l) 결과 반환 */ 
	 return lottery.add(l);
	 }
 public boolean deleteObject(Lottery l) {
	 /* lottery.remove(l); win.remove(l) */ 
	 boolean isRemove=lottery.remove(l);
	 if(isRemove) {
		 win.remove(l);
	 }
	 return isRemove;
	 }
 public HashSet<Lottery> winObject() {
     // lottery 크기 >= 4 전제
     // lottery -> ArrayList 변환 후 무작위 인덱스로 4명 구성
     // 기존 win에서 삭제된 대상 제거 후 부족분만 채움
     // win 반환
	 if(win.size()<4) {
		 Random rand=new Random();
		 
		 ArrayList<Lottery> list=new ArrayList<>();
		 list.addAll(lottery);
		 
		 while(win.size()<4&&win.size()!=lottery.size()) {
			 int index=rand.nextInt(list.size());
			 win.add(list.get(index));
		 }
	 }
	 return win;
 }
// public TreeSet<Lottery> sortedWinObject() {
//     // new TreeSet<>(new SortedLottery()) 로 win 이관, 반환
//     // (win이 준비돼 있어야 함)
// }
 public boolean searchWinner(Lottery l) {
	 /* win.contains(l) */
     return win.contains(l);
	 }
}