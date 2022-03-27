package real.m3_27_xhs;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] val = new int[n];
		for (int i = 0; i < n; i++) {
			val[i] = in.nextInt();
		}

		//选出价值最大的
		int res = get(val, k);
		System.out.println(res);
	}

	private static int getMaxGap(int[] val, int k) {
		Arrays.sort(val);
		int min = val[0];
		int max = val[val.length - 1];
		if (val.length % 2 == 0) {
			int mid = val.length / 2;
			return val[mid] - min > max - val[mid] ? max - val[mid] : val[mid] - min;
		}

		int mid1 = val.length / 2;
		int mid2 = mid1 + 1;
		return Math.max(val[mid1] - min > max - val[mid1] ? max - val[mid1] : val[mid1] - min, val[mid2] - min > max - val[mid2] ? max - val[mid2] : val[mid2] - min);
	}
	
	private static int get(int[] val, int k) {
		Arrays.sort(val);
		int min = Integer.MAX_VALUE;
		int gap = val.length / k + 1;
		for (int i = 0; i < k - 1; i++) {
			min = Math.min(min, val[gap * (i + 1)] - val[gap * i]);
		}
		return min;
	}

}
