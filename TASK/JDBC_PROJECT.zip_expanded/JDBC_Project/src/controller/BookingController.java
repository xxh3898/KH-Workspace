package controller;

import java.sql.Timestamp;
import java.util.List;
import model.vo.Booking;
import model.vo.Screening;
import service.BookingService;
import service.ScreeningService;

public class BookingController {
	private BookingService service = new BookingService();
	private ScreeningService screeningService = new ScreeningService();

	public int insertBookingExample(Booking b) {
		return service.insertBooking(b);
	}

	public int updateBookingExample(Booking b) {
		return service.updateBooking(b);
	}

	public int deleteBookingExample(int bookingId) {
		return service.deleteBooking(bookingId);
	}

	public List<Booking> selectAllExample() {
		return service.selectAll();
	}

	public Booking selectByIdExample(int bookingId) {
		return service.selectById(bookingId);
	}

	public Timestamp getScreeningTime(int screeningId) {
		Screening s = screeningService.selectById(screeningId);
		return s != null ? s.getScreeningTime() : null;
	}

	public Screening getScreeningById(int screeningId) {
		return screeningService.selectById(screeningId);
	}
}