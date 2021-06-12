package Code;

import java.util.Scanner;

public class M1434 {
	
	public static int[] getEach(int n, int count) {
		int[] num = new int[count];
		for (int i = 0; i < count; i++) {
			num[count - 1 - i] = n % 10;
			n = (n - num[count - 1 - i])/10;
		}
		return num;
		
	}
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = scanner.nextInt();
		int flag = 0;
		for (int i = 10000; i <= 99999; i++) {
			int[] num = getEach(i, 5);
			if (num[0] == num[4] && num[1] == num[3]) {
				if (2*num[0] + 2*num[1] + num[2] == sum) {
					System.out.println(i);
					flag++;
				}
			}
		}
		for (int i = 100000; i <= 999999; i++) {
			int[] num = getEach(i, 6);
			if (num[0] == num[5] && num[1] == num[4] && num[2] == num[3]) {
				if (2*num[0] + 2*num[1] + 2*num[2] == sum) {
					System.out.println(i);
					flag++;
				}
			}
		}
		if (flag == 0) {
			System.out.println(-1);
		}
		
		
		
	}
}
