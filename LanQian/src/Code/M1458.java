package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M1458 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		scanner.nextLine();
		List<Integer> number = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			String str = scanner.nextLine().trim();
			String[] temp = str.split(" ");
			for (int j = 0; j < temp.length; j++) {
				if (!temp[j].equals("")) {
					number.add(Integer.valueOf(temp[j]));
				}
			}
			
		}
		for (int i = 0; i < number.size(); i++) {
			for (int j = i + 1; j < number.size(); j++) {
				if (number.get(i) > number.get(j)) {
					Integer temp = number.get(i);
					number.set(i, number.get(j));
					number.set(j, temp);
				}
			}
		}
		int n = number.get(number.size() - 1);
		int m = number.get(number.size() - 1);
		for (int i = 0; i < number.size() - 1; i++) {
			if (number.get(i).equals(number.get(i + 1))) { //ÖØºÅ
				n = number.get(i);
			}
			else if (!number.get(i + 1).equals(number.get(i) + 1)) {
				m = number.get(i) + 1;
			}
		}
		System.out.println(m + " " + n);
	}

}
