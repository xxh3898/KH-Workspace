package inherit;

public class BusinessMan {
	private String company;
	private String position;
	public BusinessMan(String company, String position) {
		super();
		
		this.company=company;
		this.position=position;
	}
	
	public void tellYourInfo() {
		System.out.println("my company is "+company);
		System.out.println("my position is "+position);
		super.tellYourName();
	}
}
