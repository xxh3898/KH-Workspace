package com.kh.example.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {

    private MemberController mc = new MemberController();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        System.out.println("========== KH 사이트 ==========");

        while (true) {
            System.out.println("=====***** 메인 메뉴 *****=====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 같은 이름 회원 찾기");
            System.out.println("9. 종료");
            System.out.print("메뉴 번호 입력 : ");

            int sec = sc.nextInt();
            sc.nextLine(); // flush the newline

            switch (sec) {
                case 1:
                    joinMembership();
                    break;
                case 2:
                    logIn();
                    memberMenu();
                    break;
                case 3:
                    sameName();
                    break;
                case 9:
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
            }
            System.out.println();
        }
    }

    public void joinMembership() {
        while (true) {
            System.out.print("아이디 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 : ");
            String pwd = sc.nextLine();
            System.out.print("이름 : ");
            String name = sc.nextLine();

            boolean isOk = mc.joinMembership(id, new Member(id, pwd));
            if (isOk) {
                System.out.println("성공적으로 회원가입 완료하였습니다.");
                return;
            }
            System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
        }
    }

    public void logIn() {
        for (int i = 0; i < 3; i++) {
            System.out.print("아이디 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 : ");
            String pwd = sc.nextLine();

            String name = mc.logIn(id, pwd);
            if (name != null) {
                System.out.println(name + "님, 환영합니다!");
                return;
            }
            System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
        }
    }

    public void memberMenu() {
        while (true) {
            System.out.println("****** 회원 메뉴 ******");
            System.out.println("1. 비밀번호 바꾸기");
            System.out.println("2. 이름 바꾸기");
            System.out.println("3. 로그아웃");
            System.out.print("메뉴 번호 선택 : ");

            int menu = sc.nextInt();
            sc.nextLine(); // flush

            switch (menu) {
                case 1:
                    changePassword();
                    break;
                case 2:
                    changeName();
                    break;
                case 3:
                    System.out.println("로그아웃 되었습니다.");
                    return;
                default:
                    System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
            }
        }
    }

    public void changePassword() {
        while (true) {
            System.out.print("아이디 : ");
            String id = sc.nextLine();
            System.out.print("현재 비밀번호 : ");
            String oldPw = sc.nextLine();
            System.out.print("변경할 비밀번호 : ");
            String newPw = sc.nextLine();

            boolean result = mc.changePassword(id, oldPw, newPw);
            if (result) {
                System.out.println("비밀번호 변경에 성공했습니다.");
                return;
            } else {
                System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
            }
        }
    }

    public void changeName() {
        while (true) {
            System.out.print("아이디 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 : ");
            String pw = sc.nextLine();

            String currentName = mc.logIn(id, pw);
            if (currentName != null) {
                System.out.println("현재 저장된 이름 : " + currentName);
                System.out.print("변경할 이름 : ");
                String newName = sc.nextLine();
                mc.changeName(id, newName);
                System.out.println("이름 변경에 성공하였습니다.");
                return;
            } else {
                System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요.");
            }
        }
    }

    public void sameName() {
        System.out.print("검색할 이름 : ");
        String name = sc.nextLine();

        TreeMap<String, String> same = mc.sameName(name);
        if (same.isEmpty()) {
            System.out.println("해당 이름을 가진 회원이 없습니다.");
        } else {
            for (Map.Entry<String, String> entry : same.entrySet()) {
                System.out.println(entry.getValue() + " - " + entry.getKey());
            }
        }
    }
}
