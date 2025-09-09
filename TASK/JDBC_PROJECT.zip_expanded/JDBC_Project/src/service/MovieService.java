package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import model.dao.MovieDao;
import model.vo.Movie;

public class MovieService {
	private MovieDao dao = new MovieDao();

	public int insertMovie(Movie m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.insertMovie(conn, m);
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

	public int updateMovie(Movie m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.updateMovie(conn, m);
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

	public int deleteMovie(int movieId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		try {
			result = dao.deleteMovie(conn, movieId);
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

	public List<Movie> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		List<Movie> list = null;
		try {
			list = dao.selectAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}

	public Movie selectById(int movieId) {
		Connection conn = JDBCTemplate.getConnection();
		Movie m = null;
		try {
			m = dao.selectById(conn, movieId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return m;
	}
}
