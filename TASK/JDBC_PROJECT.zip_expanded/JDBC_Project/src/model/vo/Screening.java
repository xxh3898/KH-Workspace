package model.vo;

import java.sql.Timestamp;

public class Screening {
	private int screeningId;
	private int movieId;
	private String title; // 영화 제목
	private String name;
	private Timestamp screeningTime;

	// 조회용 생성자 (영화 제목 포함)
	public Screening(int screeningId, int movieId, String title, String name, Timestamp screeningTime) {
		this.screeningId = screeningId;
		this.movieId = movieId;
		this.title = title;
		this.name=name;
		this.screeningTime = screeningTime;
	}

	// 등록용 생성자 (영화 제목 없이 상영 등록용)
	public Screening(int movieId, String name, Timestamp screeningTime) {
		this.movieId = movieId;
		this.name = name;
		this.screeningTime = screeningTime;
	}

	// getter & setter
	public int getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(int screeningId) {
		this.screeningId = screeningId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public Timestamp getScreeningTime() {
		return screeningTime;
	}

	public void setScreeningTime(Timestamp screeningTime) {
		this.screeningTime = screeningTime;
	}

	@Override
	public String toString() {
		return "상영번호: " + screeningId + " / 영화 제목: " + (title != null ? title : "등록되지 않음") + " / 상영관: " + name
				+ " / 상영시간 : "+ screeningTime;
	}
}
