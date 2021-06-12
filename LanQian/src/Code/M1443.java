package Code;

import java.util.Scanner;

public class M1443 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int t = scanner.nextInt();
		
		
		Long start = 1L;
		Long gap = 0L;
		
		Long res = 0L;
		
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < n; j++) {
				start = start + gap;
				Long temp = (start) % k;
				gap++;
				
				if (j == 0) {
					res += temp;
				}
			}
		}
		
		
		System.out.println(res);
	}

}
