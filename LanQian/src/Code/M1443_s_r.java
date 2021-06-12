package Code;

import java.util.Scanner;

public class M1443_s_r {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Long n = scanner.nextLong();
		Long k = scanner.nextLong();
		Long t = scanner.nextLong();
		
		
		
		Long res = 0L;
		Long start = 0L;
		Long end = 0L;
		Long temp = 1L;
		
		for (Long i = 0L; i < t; i++) {
			temp = (temp + (start + end) * (end - start + 1) / 2) % k;
			res = res + temp;
			
			start = end + 1;
			end = end + n;
		}
		
		
		System.out.println(res);
	}

}
