package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Booking;

public class BookingDao {

	// 예약 등록
	public int insertBooking(Connection conn, Booking b) throws SQLException {
		String sql = "INSERT INTO BOOKING (MEMBER_NO, SCREENING_NO, SEAT_NUMBER, BOOKING_DATE) "
				+ "VALUES (?, ?, ?, SYSDATE)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, b.getMemberNo());
			pstmt.setInt(2, b.getScreeningId());
			pstmt.setInt(3, b.getSeatNumber());
			return pstmt.executeUpdate();
		}
	}

	// 예약 수정
	public int updateBooking(Connection conn, Booking b) throws SQLException {
		String sql = "UPDATE BOOKING SET MEMBER_NO=?, SCREENING_NO=?, SEAT_NUMBER=? WHERE BOOKING_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, b.getMemberNo());
			pstmt.setInt(2, b.getScreeningId());
			pstmt.setInt(3, b.getSeatNumber());
			pstmt.setInt(4, b.getBookingId());
			return pstmt.executeUpdate();
		}
	}

	// 예약 삭제
	public int deleteBooking(Connection conn, int bookingId) throws SQLException {
		String sql = "DELETE FROM BOOKING WHERE BOOKING_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bookingId);
			return pstmt.executeUpdate();
		}
	}

	// 전체 조회
	public List<Booking> selectAll(Connection conn) throws SQLException {
		List<Booking> list = new ArrayList<>();
		String sql = "SELECT b.BOOKING_NO, b.MEMBER_NO, m.MEMBER_ID, b.SCREENING_NO, b.SEAT_NUMBER, b.BOOKING_DATE "
				+ "FROM BOOKING b JOIN MEMBER m ON b.MEMBER_NO = m.MEMBER_NO";
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				list.add(new Booking(rs.getInt("BOOKING_NO"), rs.getInt("MEMBER_NO"), rs.getString("MEMBER_ID"),
						rs.getInt("SCREENING_NO"), rs.getInt("SEAT_NUMBER"), rs.getTimestamp("BOOKING_DATE")));
			}
		}
		return list;
	}

	// ID로 조회
	public Booking selectById(Connection conn, int bookingId) throws SQLException {
		String sql = "SELECT b.BOOKING_NO, b.MEMBER_NO, m.MEMBER_ID, b.SCREENING_NO, b.SEAT_NUMBER, b.BOOKING_DATE "
				+ "FROM BOOKING b JOIN MEMBER m ON b.MEMBER_NO = m.MEMBER_NO WHERE b.BOOKING_NO=?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bookingId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Booking(rs.getInt("BOOKING_NO"), rs.getInt("MEMBER_NO"), rs.getString("MEMBER_ID"),
							rs.getInt("SCREENING_NO"), rs.getInt("SEAT_NUMBER"), rs.getTimestamp("BOOKING_DATE"));
				}
			}
		}
		return null;
	}
}