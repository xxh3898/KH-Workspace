package model.vo;

public class Movie {
	private int movieNo;
	private String title;
	private String genre;
	private String director;
	private int runtime;

	// 조회용
	public Movie(int movieNo, String title, String genre, String director, int runtime) {
		this.movieNo = movieNo;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.runtime = runtime;
	}

	// 등록용
	public Movie(String title, String genre, String director, int runtime) {
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.runtime = runtime;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	@Override
	public String toString() {
		return "MovieNo : " + movieNo + " / 제목 : " + title + " /  장르 : " + genre + " / 감독 : " + director
				+ " / runtime : " + runtime + "분";
	}
}
