package oneDay.leetcode;


//bfs+记忆化搜索（要搜索重复值
public class l_787_2 {
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[][] step = new int[n][n];
		for (int[] item : flights) {
			step[item[0]][item[1]] = item[2];
		}
		
		
		int[][] s = new int[n][k + 2];
		
		int ans = dfs(k + 1, s, step, src, dst);
		if (ans == 1000007) {
			return -1;
		}
		
		return ans;
		
    }
	
	public static int dfs(int count, int[][] s, int[][] step, int cur, int dst) {
		if (count < 0) {
			return 1000007;
		}
		
		if (cur == dst) {
			return 0;
		}
		
		if (s[cur][count] != 0) {
			return s[cur][count];
		}
		
		int min = 1000007;
		for (int i = 0; i < step.length; i++) {
			if (step[cur][i] != 0) {
				min = Math.min(step[cur][i] + dfs(count - 1, s, step, i, dst), min);
			}
		}
		s[cur][count] = min;
		return min;
	}

	public static void main(String[] args) {
//		int n = 5;
//		int[][] flights = {
//				{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}
//		};
//		int src = 2, dst = 1, k = 1;
		
//		int n = 3;
//		int[][] flights = {
//				{0,1,100},{1,2,100},{0,2,500}
//		};
//		int src = 0, dst = 2, k = 2;
		
		int n = 3;
		int[][] flights = {
				{0,1,100},{1,2,100},{0,2,500}
		};
		int src = 0, dst = 2, k = 0;
		System.out.println(findCheapestPrice(n, flights, src, dst, k));
	}

}
