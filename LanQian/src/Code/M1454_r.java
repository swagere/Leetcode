package Code;

import java.util.Scanner;

public class M1454_r {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] number = new int[n];
		for (int i = 0; i < n; i++) {
			number[i] = scanner.nextInt();
		}
		
		int a = number[0];
		int count = 1;

		for (int i = 1; i < n; i++) {
			if (a > 0) {
				if (Math.abs(number[i]) > a && number[i] < 0) {
					count++;
				}
				else if (Math.abs(number[i]) < a && number[i] > 0) {
					count++;
				}
			}
			else if (a < 0) {
				if (Math.abs(number[i]) < -a && number[i] > 0) {
					count++;
				}
				else if (Math.abs(number[i]) > -a && number[i] < 0) {
					count++;
				}
			}
		}
		System.out.println(count);
		
		

	}

}
