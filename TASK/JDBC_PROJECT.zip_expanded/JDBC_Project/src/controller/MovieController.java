package controller;

import java.util.List;
import model.vo.Movie;
import service.MovieService;

public class MovieController {
	private MovieService service = new MovieService();

	public int insertMovieExample(Movie m) {
		return service.insertMovie(m);
	}

	public int updateMovieExample(Movie m) {
		return service.updateMovie(m);
	}

	public int deleteMovieExample(int movieId) {
		return service.deleteMovie(movieId);
	}

	public List<Movie> selectAllExample() {
		return service.selectAll();
	}

	public Movie selectByIdExample(int movieId) {
		return service.selectById(movieId);
	}

}
