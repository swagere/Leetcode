package Code;

import java.util.Scanner;

public class M1443_s {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Long n = scanner.nextLong();
		Long k = scanner.nextLong();
		Long t = scanner.nextLong();
		
		
		
		Long res = 1L;
		Long temp = 0L;
		
		for (Long i = 1L; i < t; i++) {
			temp = (1 + ((1 + n*i) * (n*i) / 2)) % k;
//			temp = (1 + ((1 + n*i) % k * (n*i) / 2) % k) % k;
			res = res + temp;
		}
		
		
		System.out.println(res);
	}

}
