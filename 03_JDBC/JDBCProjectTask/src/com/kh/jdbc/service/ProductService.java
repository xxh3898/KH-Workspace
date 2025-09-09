package com.kh.jdbc.service;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.dao.ProductDao;
import com.kh.jdbc.vo.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductService {

	private ProductDao productDao = new ProductDao();

	public List<Product> getAllProducts() {
		try (Connection conn = JDBCTemplate.getConnection()) {
			return productDao.selectAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<String> getCategories() {
		try (Connection conn = JDBCTemplate.getConnection()) {
			return productDao.selectCategories(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> getProductsByCategory(String category) {
		try (Connection conn = JDBCTemplate.getConnection()) {
			return productDao.selectByCategory(conn, category);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Product getProductById(int productId) {
		try (Connection conn = JDBCTemplate.getConnection()) {
			return productDao.getProductById(conn, productId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateStock(int productId, int qtyChange) {
		try (Connection conn = JDBCTemplate.getConnection()) {
			int result = productDao.updateStockAndSoldOut(conn, productId, qtyChange);
			if (result > 0) {
				JDBCTemplate.commit(conn);
				return true;
			} else {
				JDBCTemplate.rollback(conn);
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
