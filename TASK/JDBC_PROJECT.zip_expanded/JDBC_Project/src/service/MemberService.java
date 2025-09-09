package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import model.dao.MemberDao;
import model.vo.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.insertMember(conn, m); // MEMBER_SEQ.NEXTVAL로 member_no 자동 생성
			if (result > 0)
				JDBCTemplate.commit(conn);
			else
				JDBCTemplate.rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.updateMember(conn, m); // member_no 기준 업데이트
			if (result > 0)
				JDBCTemplate.commit(conn);
			else
				JDBCTemplate.rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int deleteMember(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.deleteMember(conn, memberNo);
			if (result > 0)
				JDBCTemplate.commit(conn);
			else
				JDBCTemplate.rollback(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public List<Member> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		List<Member> list = null;
		try {
			list = dao.selectAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public Member selectByNo(int memberNo) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = null;
		try {
			m = dao.selectByNo(conn, memberNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return m;
	}

	public Member login(String memberId, String password) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = null;
		try {
			m = dao.loginMember(conn, memberId, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return m;
	}
}
