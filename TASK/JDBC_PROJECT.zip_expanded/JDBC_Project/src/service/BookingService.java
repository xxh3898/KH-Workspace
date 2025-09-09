package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import model.dao.BookingDao;
import model.vo.Booking;

public class BookingService {
    private BookingDao dao = new BookingDao();

    public int insertBooking(Booking b) {
        Connection conn = JDBCTemplate.getConnection();
        int result = 0;
        try {
            result = dao.insertBooking(conn, b);
            if (result > 0) JDBCTemplate.commit(conn);
            else JDBCTemplate.rollback(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCTemplate.rollback(conn);
        } finally {
            JDBCTemplate.close(conn);
        }
        return result;
    }

    public int updateBooking(Booking b) {
        Connection conn = JDBCTemplate.getConnection();
        int result = 0;
        try {
            result = dao.updateBooking(conn, b);
            if (result > 0) JDBCTemplate.commit(conn);
            else JDBCTemplate.rollback(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCTemplate.rollback(conn);
        } finally {
            JDBCTemplate.close(conn);
        }
        return result;
    }

    public int deleteBooking(int bookingId) {
        Connection conn = JDBCTemplate.getConnection();
        int result = 0;
        try {
            result = dao.deleteBooking(conn, bookingId);
            if (result > 0) JDBCTemplate.commit(conn);
            else JDBCTemplate.rollback(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCTemplate.rollback(conn);
        } finally {
            JDBCTemplate.close(conn);
        }
        return result;
    }

    public List<Booking> selectAll() {
        Connection conn = JDBCTemplate.getConnection();
        List<Booking> list = null;
        try {
            list = dao.selectAll(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(conn);
        }
        return list;
    }

    public Booking selectById(int bookingId) {
        Connection conn = JDBCTemplate.getConnection();
        Booking b = null;
        try {
            b = dao.selectById(conn, bookingId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(conn);
        }
        return b;
    }
}