package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M1004 {
	public static int birth(int n) {
		if (n <= 4) return n;
		return birth(n-1) + birth(n-3);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		List year = new ArrayList();
		while(a != 0) {
			year.add(a);
			a = scanner.nextInt();
		}
		for (int i = 0; i < year.size(); i++) {
			System.out.println(birth((int)year.get(i)));
		}

	}

}
