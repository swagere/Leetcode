package real.m4_14_blf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
	static final int mod = 1000000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] f_prices = in.nextLine().split(" ");
		String[] b_prices = in.nextLine().split(" ");
		String[] g_prices = in.nextLine().split(" ");
		
		//prices
		int max = Math.max(f_prices.length, Math.max(b_prices.length, g_prices.length));
		int[][] prices = new int[3][max];
		for (int i = 0; i < f_prices.length; i++) prices[0][i] = Integer.valueOf(f_prices[i]);
		for (int i = 0; i < b_prices.length; i++) prices[1][i] = Integer.valueOf(b_prices[i]);
		for (int i = 0; i < g_prices.length; i++) prices[2][i] = Integer.valueOf(g_prices[i]);
		Arrays.sort(prices[0]);
		Arrays.sort(prices[1]);
		Arrays.sort(prices[2]);
		int target = in.nextInt();
		getSelectCount(prices, target, 0);
		System.out.println((count + 1) % mod);

	}
	
	static int count = -1;
	public static boolean getSelectCount(int[][] prices, int target, int index) {
		if (index == 3) {
			if (target >= 0) {
				count = (count + 1) % mod;
				return true;
			}
			return false;
		}
		
		if (target  <= 0) {
			return false;
		}
		
		boolean res = true;
		for (int i = 0; i < prices[index].length; i++) {
			if (prices[index][i] != 0) {
				res = getSelectCount(prices, target - prices[index][i], index + 1);
			}
			if (!res) {
				break;
			}
		}
		return true;
	}

}
