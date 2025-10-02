
package com.kh.jsp.model.dao;

import static com.kh.jsp.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.jsp.common.JDBCTemplate;
import com.kh.jsp.model.vo.Board;

public class BoardDao {
	private Properties prop = new Properties();

	public BoardDao() {
		super();

		String path = JDBCTemplate.class.getResource("/db/sql/board-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Board> showBoard(Connection conn) {
	    List<Board> list = new ArrayList<>();
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    String sql = prop.getProperty("showBoard");
	    
	    try {
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        
	        while(rs.next()) {
	            Board b = new Board(
	                rs.getInt("BOARD_NO"),
	                rs.getInt("BOARD_TYPE"),
	                rs.getInt("CATEGORY_NO"),
	                rs.getString("BOARD_TITLE"),
	                rs.getString("BOARD_CONTENT"),
	                rs.getInt("BOARD_WRITER"),
	                rs.getInt("COUNT"),
	                rs.getDate("CREATE_DATE"),
	                rs.getString("STATUS")
	            );
	            list.add(b);
	        }
	    } catch(SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(rs);
	        close(pstmt);
	    }
	    
	    return list;
	}


}
