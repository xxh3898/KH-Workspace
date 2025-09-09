package controller;

import java.util.List;
import model.vo.Screen;
import service.ScreenService;

public class ScreenController {
	private ScreenService service = new ScreenService();

	public int insertScreenExample(Screen s) {
		return service.insertScreen(s);
	}

	public int updateScreenExample(Screen s) {
		return service.updateScreen(s);
	}

	public int deleteScreenExample(int screenId) {
		return service.deleteScreen(screenId);
	}

	public List<Screen> selectAllExample() {
		return service.selectAll();
	}

	public Screen selectByIdExample(int screenId) {
		return service.selectById(screenId);
	}
}
