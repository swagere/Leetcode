package real.m9_12_aqy;

import java.util.Scanner;

public class Main1 {
	public static int getGroupCount(int n) {
		int[] count = new int[73];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int sum = getSingleSum(i);
			count[sum] += 1;
			if (max < count[sum]) {
				max = count[sum];
			}
		}
		
		int res = 0;
		for (int i = 1; i < 73; i++) {
			if (count[i] == max) {
				res += 1;
			}
		}
		
		return res;
	}
	
	public static int getSingleSum(int n) {
		int sum = 0;
		while (n > 9) {
			sum += n % 10;
			n = n / 10;
		}
		sum += n;
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(getGroupCount(n));
	}

}
