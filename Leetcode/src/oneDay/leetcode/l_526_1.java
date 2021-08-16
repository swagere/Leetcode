package oneDay.leetcode;

import java.util.Arrays;

//r
//递归
public class l_526_1 {
	static int[] isVisited;
	static int count = 0;
	public static int countArrangement(int n) {
		isVisited = new int[n + 1];
		
		getArray(1, n);
		return count;
    }
	
	public static void getArray(int index, int n) {
		if (index == n + 1) {
			count++;
			System.out.println(Arrays.toString(isVisited));
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (index % i == 0 || i % index == 0) {
				if (isVisited[i] == 0) {
					isVisited[i] = 1;
					getArray(index + 1, n);
					isVisited[i] = 0;
				}
				
			}
		}
	}

	public static void main(String[] args) {
		int n = 2;
		System.out.println(countArrangement(n));
	}

}
