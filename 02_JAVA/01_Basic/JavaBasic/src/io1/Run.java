package io1;

import java.io.File;
import java.io.IOException;

public class Run {
	/*
	 * 간단하게 파일/폴더 생성, 정보확인
	 * java.io.File class를 이용하면 됨
	 * - 파일/폴더 경로를 표현하는 객체
	 * 
	 * 상대경로 : 지금 내 위치를 기반으로 다른 경로를 탐색하는 것
	 * 절대경로 : Window -> C:~, D:~, Unix -> /root/~ 최상위 루트를 기준으로 다른 경로를 탐색
	 */
	public static void main(String[] args) {
		//1. 경로지정 없이 파일객체를 생성(상대경로 - 현재 작업 폴더 기준)
		File f1=new File("test.txt");
		
		//2. 실제 존제하는 경로에 파일생성
		File f2=new File("D:\\test.txt");
		
		//3. 존재하지 않느 경로에 파일 생성
		File f3=new File("D:\\tmp\\test.txt");
		
		try {
			f1.createNewFile();
			f2.createNewFile();
			f3.createNewFile();
			File tmpFolder =new File("D:\\\\tmp");
			tmpFolder.mkdir();
			//파일정보 가져오기
			File f4=new File("ttt.txt");
			f4.exists();
			//파일 존재우무 확인
			System.out.println("exist : "+f4.exists());
			System.out.println("exist : "+f1.exists());
			
			System.out.println("isFile : "+f1.isFile());
			System.out.println("isFile : "+tmpFolder.isFile());
			
			System.out.println("파일명 : "+f1.getName());
			System.out.println("파일경로 : "+f1.getAbsolutePath());
			System.out.println("파일용량 : "+f1.length());
			System.out.println("파일상위폴더 : "+f1.getParent());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
