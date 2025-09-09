package example.poly2;

public class CookBook extends Book{
	private  boolean coupon;

	public CookBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CookBook(String title, String author, String publisher, boolean coupon) {
		super(title, author, publisher);
		this.coupon=coupon;
	}

	public boolean isCoupon() {
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+", "+coupon;
	}
	
}
