package oneDay.leetcode;

import java.util.Arrays;

//r
//dfs
public class l_526_2 {
	public static int countArrangement(int n) {
		int[] isVisited = new int[n + 1];
		
		int res = getArray(1, n, isVisited);
		return res;
    }
	
	public static int getArray(int index, int n, int[] isVisited) {
		if (index == n + 1) {
			System.out.println(Arrays.toString(isVisited));
			return 1;
		}
		
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (index % i == 0 || i % index == 0) {
				if (isVisited[i] == 0) {
					int[] visited = Arrays.copyOf(isVisited, n + 1);
					visited[i] = 1;
					ans += getArray(index + 1, n, visited);
				}
				
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println(countArrangement(n));
	}

}
