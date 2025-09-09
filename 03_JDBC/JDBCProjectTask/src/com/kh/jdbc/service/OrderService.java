package com.kh.jdbc.service;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.dao.OrderDao;
import com.kh.jdbc.dao.ProductDao;
import com.kh.jdbc.vo.Order;
import com.kh.jdbc.vo.OrderItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderService {
	private OrderDao orderDao = new OrderDao();
	private ProductDao productDao = new ProductDao();

	public boolean placeOrder(Order order) {
		Connection conn = null;
		boolean success = false;
		try {
			conn = JDBCTemplate.getConnection();
			conn.setAutoCommit(false);

			int result = orderDao.insertOrder(conn); // ORDERS 테이블에 새 주문
			if (result == 0)
				throw new SQLException("주문 insert 실패");

			int orderId = getLastOrderId(conn); // 마지막 order_id 가져오기

			orderDao.insertOrderItems(conn, order.getItems(), orderId);

			// 재고 차감 & 품절 체크
			for (OrderItem item : order.getItems()) {
				productDao.updateStockAndSoldOut(conn, item.getProductId(), -item.getQuantity());
			}

			JDBCTemplate.commit(conn);
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
		} finally {
			JDBCTemplate.close(conn);
		}
		return success;
	}

	private int getLastOrderId(Connection conn) throws SQLException {
		String sql = "SELECT MAX(ORDER_ID) AS ORDER_ID FROM ORDERS";
		try (var stmt = conn.createStatement(); var rs = stmt.executeQuery(sql)) {
			if (rs.next())
				return rs.getInt("ORDER_ID");
		}
		return -1;
	}
}
