package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Member;

public class MemberDao {

	// 회원 등록
	public int insertMember(Connection conn, Member m) throws SQLException {
		String sql = "INSERT INTO MEMBER (MEMBER_ID, PASSWORD, NAME, EMAIL, PHONE, JOIN_DATE) "
				+ "VALUES (?, ?, ?, ?, ?, SYSDATE)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			return pstmt.executeUpdate();
		}
	}

	// 회원 수정
	public int updateMember(Connection conn, Member m) throws SQLException {
		String sql = "UPDATE MEMBER SET MEMBER_ID=?, PASSWORD=?, NAME=?, EMAIL=?, PHONE=? WHERE MEMBER_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			pstmt.setInt(6, m.getMemberNo());
			return pstmt.executeUpdate();
		}
	}

	// 회원 삭제
	public int deleteMember(Connection conn, int memberNo) throws SQLException {
		String sql = "DELETE FROM MEMBER WHERE MEMBER_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, memberNo);
			return pstmt.executeUpdate();
		}
	}

	// 전체 조회
	public List<Member> selectAll(Connection conn) throws SQLException {
		List<Member> list = new ArrayList<>();
		String sql = "SELECT MEMBER_NO, MEMBER_ID, PASSWORD, NAME, EMAIL, PHONE, JOIN_DATE FROM MEMBER";
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				list.add(new Member(rs.getInt("MEMBER_NO"), rs.getString("MEMBER_ID"), rs.getString("PASSWORD"),
						rs.getString("NAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getDate("JOIN_DATE")));
			}
		}
		return list;
	}

	// 번호로 조회
	public Member selectByNo(Connection conn, int memberNo) throws SQLException {
		String sql = "SELECT MEMBER_NO, MEMBER_ID, PASSWORD, NAME, EMAIL, PHONE, JOIN_DATE FROM MEMBER WHERE MEMBER_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, memberNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Member(rs.getInt("MEMBER_NO"), rs.getString("MEMBER_ID"), rs.getString("PASSWORD"),
							rs.getString("NAME"), rs.getString("EMAIL"), rs.getString("PHONE"),
							rs.getDate("JOIN_DATE"));
				}
			}
		}
		return null;
	}

	// 로그인용: 아이디와 비밀번호로 조회
	public Member loginMember(Connection conn, String memberId, String password) throws SQLException {
		String sql = "SELECT MEMBER_NO, MEMBER_ID, PASSWORD, NAME, EMAIL, PHONE, JOIN_DATE "
				+ "FROM MEMBER WHERE MEMBER_ID=? AND PASSWORD=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, memberId);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Member(rs.getInt("MEMBER_NO"), rs.getString("MEMBER_ID"), rs.getString("PASSWORD"),
							rs.getString("NAME"), rs.getString("EMAIL"), rs.getString("PHONE"),
							rs.getDate("JOIN_DATE"));
				}
			}
		}
		return null;
	}
}
