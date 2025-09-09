package com.kh.jdbc.dao;

import com.kh.jdbc.vo.Order;
import com.kh.jdbc.vo.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {

	public int insertOrder(Connection conn) throws SQLException {
		String sql = "INSERT INTO ORDERS(ORDER_ID) VALUES(ORDERS_SEQ.NEXTVAL)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			return pstmt.executeUpdate();
		}
	}

	public void insertOrderItems(Connection conn, List<OrderItem> items, int orderId) throws SQLException {
		String sql = "INSERT INTO ORDER_ITEM(ORDER_ITEM_ID, ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(ORDER_ITEM_SEQ.NEXTVAL, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			for (OrderItem item : items) {
				pstmt.setInt(1, orderId);
				pstmt.setInt(2, item.getProductId());
				pstmt.setInt(3, item.getQuantity());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		}
	}
}
