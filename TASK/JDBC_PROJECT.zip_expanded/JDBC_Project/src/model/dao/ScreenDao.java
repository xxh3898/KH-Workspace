package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Screen;

public class ScreenDao {

	public int insertScreen(Connection conn, Screen s) throws SQLException {
		String sql = "INSERT INTO SCREEN (NAME, SEAT_COUNT) VALUES (?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getSeatCount());
			return pstmt.executeUpdate();
		}
	}

	public int updateScreen(Connection conn, Screen s) throws SQLException {
		String sql = "UPDATE SCREEN SET NAME=?, SEAT_COUNT=? WHERE SCREEN_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getSeatCount());
			pstmt.setInt(3, s.getScreenNo());
			return pstmt.executeUpdate();
		}
	}

	public int deleteScreen(Connection conn, int screenNO) throws SQLException {
		String sql = "DELETE FROM SCREEN WHERE SCREEN_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, screenNO);
			return pstmt.executeUpdate();
		}
	}

	public List<Screen> selectAll(Connection conn) throws SQLException {
		List<Screen> list = new ArrayList<>();
		String sql = "SELECT SCREEN_NO, NAME, SEAT_COUNT FROM SCREEN";
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				list.add(new Screen(rs.getInt("SCREEN_NO"), rs.getString("NAME"), rs.getInt("SEAT_COUNT")));
			}
		}
		return list;
	}

	public Screen selectById(Connection conn, int screenNO) throws SQLException {
		String sql = "SELECT SCREEN_NO, NAME, SEAT_COUNT FROM SCREEN WHERE SCREEN_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, screenNO);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Screen(rs.getInt("SCREEN_NO"), rs.getString("NAME"), rs.getInt("SEAT_COUNT"));
				}
			}
		}
		return null;
	}
}
