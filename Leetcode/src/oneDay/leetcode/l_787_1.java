package oneDay.leetcode;

//超时
//dfs
//可能有重复值
public class l_787_1 {
	static int min = Integer.MAX_VALUE;
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[][] step = new int[n][n];
		for (int[] item : flights) {
			step[item[0]][item[1]] = item[2];
		}
		
		dfs(k + 1, 0, 0, step, src, dst, new int[n]);
		
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
		
    }
	
	public static void dfs(int k, int count, int num, int[][] step, int cur, int dst, int[] isVisited) {
		if (count > k) {
			return;
		}
		if (cur == dst) {
			if (min > num) {
				min = num;
			}
			return;
		}
		
		isVisited[cur] = 1;
		
		for (int i = 0; i < isVisited.length; i++) {
			if (isVisited[i] == 0 && step[cur][i] != 0) {
				dfs(k,count + 1, num + step[cur][i], step, i, dst, isVisited);
			}
		}
		
		isVisited[cur] = 0;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] flights = {
				{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}
		};
		int src = 2, dst = 1, k = 1;
		System.out.println(findCheapestPrice(n, flights, src, dst, k));
	}

}
