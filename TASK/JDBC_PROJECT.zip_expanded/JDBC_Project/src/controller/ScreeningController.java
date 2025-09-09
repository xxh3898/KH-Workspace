package controller;

import java.util.List;
import model.vo.Screening;
import service.ScreeningService;

public class ScreeningController {
	private ScreeningService service = new ScreeningService();

	public int insertScreeningExample(Screening s) {
		return service.insertScreening(s);
	}

	public int updateScreeningExample(Screening s) {
		return service.updateScreening(s);
	}

	public int deleteScreeningExample(int screeningId) {
		return service.deleteScreening(screeningId);
	}

	public List<Screening> selectAllExample() {
		return service.selectAll();
	}

	public Screening selectByIdExample(int screeningId) {
		return service.selectById(screeningId);
	}
}
