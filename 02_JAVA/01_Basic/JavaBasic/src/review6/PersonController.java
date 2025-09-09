package review6;

import com.kh.example.oop7.Product;

public class PersonController {
	Student[] s = new Student[3];
	Employee[] e = new Employee[10];

	public int[] personCount() {
		int[] count = new int[2];
		int scount = 0, ecount = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == null) {
				scount++;
			}
		}
		count[0] = scount;
		for (int i = 0; i < e.length; i++) {
			if (e[i] == null) {
				ecount++;
			}
		}
		count[1] = ecount;
		return count;
	}

	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == null) {
				s[i] = new Student(name, age, height, weight, grade, major);
				return;
			}
		}
	}

	public Student[] printStudent() {
		
		return s;
	}

	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for (int i = 0; i < e.length; i++) {
			if (e[i] == null) {
				e[i] = new Employee(name, age, height, weight, salary, dept);
				return;
			}
		}
	}

	public Employee[] printEmployee() {
		return e;
	}
	
	
	
}
