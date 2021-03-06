package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class l_279_1 {
	//普通递归（类似斐波拉契数列）
	 public static int numSquares(int n) {
		 if (n == 0) {
			 return n;
		 }
		 
		 //如果n为平方数
		 for (int i = 1; i <= Math.sqrt(n); i++) {
			 if (i*i == n) {
				 return 1;
			 }
		 }
		 
		 List<Integer> res = new ArrayList<Integer>();
		 for (int i = 1; i <= Math.sqrt(n); i++) {
			 res.add(numSquares(i * i) + numSquares(n - i * i));
		 }

		 //找到res中最小的
		 int min = res.get(0);
		 for (int i : res) {
			 if (i < min) {
				 min = i;
			 }
		 }
		 return min;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(numSquares(n));
	}
	
	
}
