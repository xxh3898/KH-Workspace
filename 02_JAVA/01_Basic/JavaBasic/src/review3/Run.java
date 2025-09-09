package review3;

public class Run {

	public static void main(String[] args) {
		new Book().inform();
		new Book("자바는 즐거워", "KH", "최지원").inform();
		new Book("자바는 즐거워", "KH", "최지원", 10000, 0.2).inform();
	}

}
