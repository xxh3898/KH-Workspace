package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Movie;

public class MovieDao {

	public int insertMovie(Connection conn, Movie m) throws SQLException {
		String sql = "INSERT INTO MOVIE (TITLE, GENRE, DIRECTOR, RUNTIME) " + "VALUES (?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, m.getTitle());
			pstmt.setString(2, m.getGenre());
			pstmt.setString(3, m.getDirector());
			pstmt.setInt(4, m.getRuntime());
			return pstmt.executeUpdate();
		}
	}

	public int updateMovie(Connection conn, Movie m) throws SQLException {
		String sql = "UPDATE MOVIE SET TITLE=?, GENRE=?, DIRECTOR=?, RUNTIME=? WHERE MOVIE_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, m.getTitle());
			pstmt.setString(2, m.getGenre());
			pstmt.setString(3, m.getDirector());
			pstmt.setInt(4, m.getRuntime());
			pstmt.setInt(5, m.getMovieNo());
			return pstmt.executeUpdate();
		}
	}

	public int deleteMovie(Connection conn, int movieNo) throws SQLException {
		String sql = "DELETE FROM MOVIE WHERE MOVIE_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, movieNo);
			return pstmt.executeUpdate();
		}
	}

	public List<Movie> selectAll(Connection conn) throws SQLException {
		List<Movie> list = new ArrayList<>();
		String sql = "SELECT MOVIE_NO, TITLE, GENRE, DIRECTOR, RUNTIME FROM MOVIE";
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				list.add(new Movie(rs.getInt("MOVIE_NO"), rs.getString("TITLE"), rs.getString("GENRE"),
						rs.getString("DIRECTOR"), rs.getInt("RUNTIME")));
			}
		}
		return list;
	}

	public Movie selectById(Connection conn, int movieNo) throws SQLException {
		String sql = "SELECT MOVIE_NO, TITLE, GENRE, DIRECTOR, RUNTIME FROM MOVIE WHERE MOVIE_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, movieNo);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Movie(rs.getInt("MOVIE_NO"), rs.getString("TITLE"), rs.getString("GENRE"),
							rs.getString("DIRECTOR"), rs.getInt("RUNTIME"));
				}
			}
		}
		return null;
	}
}
