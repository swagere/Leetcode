package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p_279_3 {
	
	//动态规划
	public static int numSquares(int n) {
		int[] array = new int[n + 1]; //全部初始化为0
		
		for (int i = 1; i <= n; i++) {
			List<Integer> res = new ArrayList<>();
			for (int j = 1; j * j <= i; j++) {
				res.add(1 + array[i - j * j]);
			}
			
			int min = res.get(0);
			for (int j = 1; j < res.size(); j++) {
				if (min > res.get(j)) {
					min = res.get(j);
				}
			}
			array[i] = min;
			
		}
		return array[n];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(numSquares(n));
	}
	
	
}
