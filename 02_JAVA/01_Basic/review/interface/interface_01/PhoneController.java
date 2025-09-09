package interface_01;

import java.util.Scanner;

public class PhoneController {
	private String[] result = new String[2];

	public String[] method() {
		Scanner sc = new Scanner(System.in);
		Phone[] phoneArr = new Phone[2];
		phoneArr[0] = new GalaxyNote9();
		phoneArr[1] = new V40();

		String[] result = new String[2];
		int index = 0;
		for (Phone p : phoneArr) {
			if (p instanceof SmartPhone) {
				result[index++] = ((SmartPhone) p).printInformation();
			}
		}
		for (Phone phone : phoneArr) {
			if(phone instanceof SmartPhone) {
				result[i]=((SmartPhone)phone).printInformation();
			}
		}

		return result;
	}
}
