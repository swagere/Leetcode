package Code;

import java.util.Scanner;

public class M1446 {
	static int getMax(int n, int m) {
		int r = m % n;
		while (r != 0) {
			m = n; 
			n = r;
			r = m % n;
		}
		if (r == 0) return n;
		return 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] number = new int[3];
		number[0] = scanner.nextInt();
		number[1] = scanner.nextInt();
		number[2] = scanner.nextInt();
		
		
		//获得12之间的最小公倍数
		int max_12 = getMax(number[0],number[1]);
		int min_12 = number[0] * number[1] / max_12;
		
		int max_123 = getMax(min_12, number[2]);
		int min_123 = min_12 * number[2] / max_123;
		
		System.out.println(min_123);

	}

}
