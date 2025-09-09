package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import model.dao.ScreenDao;
import model.vo.Screen;

public class ScreenService {
	private ScreenDao dao = new ScreenDao();

	public int insertScreen(Screen s) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.insertScreen(conn, s);
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

	public int updateScreen(Screen s) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.updateScreen(conn, s);
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

	public int deleteScreen(int screenId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.deleteScreen(conn, screenId);
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

	public List<Screen> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		List<Screen> list = null;
		try {
			list = dao.selectAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public Screen selectById(int screenId) {
		Connection conn = JDBCTemplate.getConnection();
		Screen s = null;
		try {
			s = dao.selectById(conn, screenId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return s;
	}
}
