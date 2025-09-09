package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import model.dao.ScreeningDao;
import model.vo.Screening;

public class ScreeningService {
	private ScreeningDao dao = new ScreeningDao();

	public int insertScreening(Screening s) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.insertScreening(conn, s);
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

	public int updateScreening(Screening s) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.updateScreening(conn, s);
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

	public int deleteScreening(int screeningId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.deleteScreening(conn, screeningId);
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

	public List<Screening> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		List<Screening> list = null;
		try {
			list = dao.selectAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public Screening selectById(int screeningId) {
		Connection conn = JDBCTemplate.getConnection();
		Screening s = null;
		try {
			s = dao.selectById(conn, screeningId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return s;
	}
}
