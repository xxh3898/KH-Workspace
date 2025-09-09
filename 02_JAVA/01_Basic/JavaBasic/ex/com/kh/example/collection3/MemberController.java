package com.kh.example.collection3;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class MemberController {

    // 회원 저장소
    private HashMap<String, Member> map = new HashMap<>();

    // 회원 가입
    public boolean joinMembership(String id, Member m) {
        if (!map.containsKey(id)) {
            map.put(id, m);
            return true;
        }
        return false;
    }

    // 로그인
    public String logIn(String id, String password) {
        Member m = map.get(id);
        if (m != null && m.getPassword().equals(password)) {
            return m.getName();
        }
        return null;
    }

    // 비밀번호 변경
    public boolean changePassword(String id, String oldPw, String newPw) {
        Member m = map.get(id);
        if (m != null && m.getPassword().equals(oldPw)) {
            m.setPassword(newPw);
            return true;
        }
        return false;
    }

    // 이름 변경
    public void changeName(String id, String newName) {
        Member m = map.get(id);
        if (m != null) {
            m.setName(newName);
        }
    }

    // 같은 이름 찾기
    public TreeMap<String, String> sameName(String name) {
        TreeMap<String, String> result = new TreeMap<>();
        for (Map.Entry<String, Member> entry : map.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                result.put(entry.getKey(), entry.getValue().getName());
            }
        }
        return result;
    }
}
