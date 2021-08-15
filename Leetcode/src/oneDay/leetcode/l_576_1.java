package oneDay.leetcode;

//超时
//dfs
public class l_576_1 {
//	static int[][] step;
	static int m;
	static int n;
	static int maxMove;
	static int count;
	static int mod = (int)1e9+7;
	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		l_576_1.m = m;
		l_576_1.n = n;
		l_576_1.maxMove = maxMove;
//		step = new int[m][n];
		dfs(startRow, startColumn, 0);
		
//		for (int i = 0; i < m; i++) {
//			System.out.println(Arrays.toString(step[i]));
//		}
		
		return count;
    }

	public static void dfs(int x, int y, int k) {
		if (x == -1 || x == m || y == -1 || y == n) {
			count = (count + 1) % mod;
			return;
		}
		
		if (k == maxMove) {
			return;
		}
		
		//处理数据
//		step[x][y] += 1;
		
		
		//四个方向 前进
		dfs(x + 1, y, k + 1);
		dfs(x, y + 1, k + 1);
		dfs(x - 1, y, k + 1);
		dfs(x, y - 1, k + 1);
	}
	
	public static void main(String[] args) {
//		int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
		int m = 8, n = 50, maxMove = 23, startRow = 5, startColumn = 26;
		
		System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
	}

}
