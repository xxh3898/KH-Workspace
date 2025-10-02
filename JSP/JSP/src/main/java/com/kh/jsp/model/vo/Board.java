package com.kh.jsp.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int boardNo;
	private int boardType;
	private int categoryNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	private int count;
	private Date createDate;
	private String status;

	public static Board showBoard(int boardNo, int boardType, int categoryNo, String boardTitle, String boardContent,
			int boardWriter, int count, Date createDate, String status) {
		Board b = new Board();

		b.setBoardNo(boardNo);
		b.setBoardType(boardType);
		b.setCategoryNo(categoryNo);
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setBoardWriter(boardWriter);
		b.setCount(count);
		b.setCreateDate(createDate);
		b.setStatus(status);

		return b;
	}
}
