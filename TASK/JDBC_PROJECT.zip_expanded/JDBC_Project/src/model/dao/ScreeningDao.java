package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.vo.Screening;

public class ScreeningDao {

	// 상영 등록
	public int insertScreening(Connection conn, Screening s) throws SQLException {
		String sql = "INSERT INTO SCREENING (MOVIE_NO, SCREEN_NO, SCREENING_TIME) VALUES (?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, s.getMovieId());
			pstmt.setInt(2, Integer.parseInt(s.getName().replace("관", ""))); // 화면에서 "1관" 입력 시 숫자만 추출
			pstmt.setTimestamp(3, s.getScreeningTime());
			return pstmt.executeUpdate();
		}
	}

	// 상영 수정
	public int updateScreening(Connection conn, Screening s) throws SQLException {
		String sql = "UPDATE SCREENING SET MOVIE_NO=?, SCREEN_NO=?, SCREENING_TIME=? WHERE SCREENING_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, s.getMovieId());
			pstmt.setInt(2, Integer.parseInt(s.getName().replace("관", "")));
			pstmt.setTimestamp(3, s.getScreeningTime());
			pstmt.setInt(4, s.getScreeningId());
			return pstmt.executeUpdate();
		}
	}

	// 상영 삭제
	public int deleteScreening(Connection conn, int screeningId) throws SQLException {
		String sql = "DELETE FROM SCREENING WHERE SCREENING_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, screeningId);
			return pstmt.executeUpdate();
		}
	}

	// 전체 조회
	public List<Screening> selectAll(Connection conn) throws SQLException {
		List<Screening> list = new ArrayList<>();
		String sql = "SELECT s.SCREENING_NO, s.MOVIE_NO, m.TITLE, sc.NAME AS SCREEN_NAME, s.SCREENING_TIME "
				+ "FROM SCREENING s " + "JOIN MOVIE m ON s.MOVIE_NO = m.MOVIE_NO "
				+ "JOIN SCREEN sc ON s.SCREEN_NO = sc.SCREEN_NO " + "ORDER BY s.SCREENING_NO";
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				list.add(new Screening(rs.getInt("SCREENING_NO"), rs.getInt("MOVIE_NO"), rs.getString("TITLE"),
						rs.getString("SCREEN_NAME"), rs.getTimestamp("SCREENING_TIME")));
			}
		}
		return list;
	}

	// 상영 ID로 조회
	public Screening selectById(Connection conn, int screeningId) throws SQLException {
		String sql = "SELECT s.SCREENING_NO, s.MOVIE_NO, m.TITLE, sc.NAME AS SCREEN_NAME, s.SCREENING_TIME "
				+ "FROM SCREENING s " + "JOIN MOVIE m ON s.MOVIE_NO = m.MOVIE_NO "
				+ "JOIN SCREEN sc ON s.SCREEN_NO = sc.SCREEN_NO " + "WHERE s.SCREENING_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, screeningId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Screening(rs.getInt("SCREENING_NO"), rs.getInt("MOVIE_NO"), rs.getString("TITLE"),
							rs.getString("SCREEN_NAME"), rs.getTimestamp("SCREENING_TIME"));
				}
			}
		}
		return null;
	}
}
