package com.kh.jdbc.dao;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.vo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	public List<Product> selectAll(Connection conn) throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT PRODUCT_ID, NAME, CATEGORY, COST AS PRICE, STOCK, SOLD_OUT FROM PRODUCT ORDER BY PRODUCT_ID";
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				list.add(new Product(rs.getInt("PRODUCT_ID"), rs.getString("NAME"), rs.getString("CATEGORY"),
						rs.getInt("PRICE"), rs.getInt("STOCK"), "O".equals(rs.getString("SOLD_OUT"))));
			}
		}
		return list;
	}

	public List<String> selectCategories(Connection conn) throws SQLException {
		List<String> categories = new ArrayList<>();
		String sql = "SELECT DISTINCT CATEGORY FROM PRODUCT ORDER BY CATEGORY";
		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				categories.add(rs.getString("CATEGORY"));
			}
		}
		return categories;
	}

	public List<Product> selectByCategory(Connection conn, String category) throws SQLException {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT PRODUCT_ID, NAME, CATEGORY, COST AS PRICE, STOCK, SOLD_OUT FROM PRODUCT WHERE CATEGORY = ? ORDER BY PRODUCT_ID";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, category);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					list.add(new Product(rs.getInt("PRODUCT_ID"), rs.getString("NAME"), rs.getString("CATEGORY"),
							rs.getInt("PRICE"), rs.getInt("STOCK"), "O".equals(rs.getString("SOLD_OUT"))));
				}
			}
		}
		return list;
	}

	public Product getProductById(Connection conn, int productId) throws SQLException {
		String sql = "SELECT PRODUCT_ID, NAME, CATEGORY, COST AS PRICE, STOCK, SOLD_OUT FROM PRODUCT WHERE PRODUCT_ID = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, productId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new Product(rs.getInt("PRODUCT_ID"), rs.getString("NAME"), rs.getString("CATEGORY"),
							rs.getInt("PRICE"), rs.getInt("STOCK"), "O".equals(rs.getString("SOLD_OUT")));
				}
			}
		}
		return null;
	}

	public int updateStockAndSoldOut(Connection conn, int productId, int qtyChange) throws SQLException {
		String sql = "UPDATE PRODUCT SET STOCK = STOCK + ?, SOLD_OUT = CASE WHEN STOCK + ? <= 0 THEN 'O' ELSE 'X' END WHERE PRODUCT_ID = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, qtyChange);
			pstmt.setInt(2, qtyChange);
			pstmt.setInt(3, productId);
			return pstmt.executeUpdate();
		}
	}
}
