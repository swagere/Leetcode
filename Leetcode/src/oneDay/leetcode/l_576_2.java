package oneDay.leetcode;

//r
//dfs+记忆化搜索
public class l_576_2 {
	static int[][][] step;
	static int m;
	static int n;
	static int maxMove;
	static int mod = (int)1e9+7;
	public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		l_576_2.m = m;
		l_576_2.n = n;
		l_576_2.maxMove = maxMove;
		
		//初始化
		step = new int[m][n][maxMove + 1];
		for (int i = 0; i < m; i++) {
		    for (int j = 0; j < n; j++) {
		        for (int k = 0; k <= maxMove; k++) {
		            step[i][j][k] = -1;
		        }
		    }
		}
		
		
		
		return dfs(startRow, startColumn, 0);
    }

	public static int dfs(int x, int y, int k) {
		if (x == -1 || x == m || y == -1 || y == n) {
			return 1;
		}
		
		if (k == maxMove) {
			return 0;
		}
		
		if (step[x][y][k] != -1) {
			return step[x][y][k];
		}
		
		int ans = 0;
	
		//四个方向 前进
		ans = (ans + dfs(x + 1, y, k + 1)) % mod;
		ans = (ans + dfs(x, y + 1, k + 1)) % mod;
		ans = (ans + dfs(x - 1, y, k + 1)) % mod;
		ans = (ans + dfs(x, y - 1, k + 1)) % mod;
		
		step[x][y][k] = ans % mod;
		
		return ans;
	}
	
	public static void main(String[] args) {
//		int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
		
		int m = 3, n = 5, maxMove = 5, startRow = 1, startColumn = 2;
		
		System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
	}

}
