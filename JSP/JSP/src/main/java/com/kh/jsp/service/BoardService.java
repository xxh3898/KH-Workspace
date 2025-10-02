package com.kh.jsp.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.jsp.model.dao.BoardDao;
import com.kh.jsp.model.vo.Board;

public class BoardService {
	public List<Board> selectBoardList() {
		Connection conn = getConnection();
		List<Board> list = new BoardDao().showBoard(conn);
		close(conn);
		return list;
	}
}
