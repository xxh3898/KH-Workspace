package example.inherit2;

public class PersonController {
	private Student[] s=new Student[3];
	private Employee[] e=new Employee[10];
	
	public int personCount() {
		int stCount=0, empCount=0;
		for(Student st:s) {
			if(st==null) {
				break;
			}
			stCount++;
		}
		for(Employee emp:e) {
			if(emp==null) {
				break;
			}
			empCount++;
		}
		int[] counArr=new int[2];
		countArr[0]=stCount;
		countArr[1]=empCount;
		return countArr;
	}
}
