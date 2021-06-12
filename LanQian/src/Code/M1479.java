package Code;

import java.util.Scanner;

public class M1479 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++ ) {
			int j = in.nextInt();
			if (j != 0) {
				System.out.print(j);
				if (i != n - 1) {
					System.out.print(" ");
				}
				count++;
			}
			
		}
		System.out.println();
		System.out.println(count);

	}

}
