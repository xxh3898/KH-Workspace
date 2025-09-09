package quiz;

import java.util.Scanner;

public class O8_12_03 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean isDup1=false;
		String str=sc.next();
		int [] count=new int[26];
		for(int i=0;i<str.length();i++) {
			int index=str.charAt(i)-'A';
			count[index]++;
		}
		int max=0;
		for(int i=0;i<count.length;i++) {
			max=count[i]>max?count[i]:max;
			if(count[i]>max) {
				max=count[i];
			}else if(count[i]==max) {
				isDup1=true;
			}
		}
		
		System.out.println((int)'B');
	}

}
