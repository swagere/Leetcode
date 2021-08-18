package oneDay.leetcode;


//r
//dfs + 记忆化搜索
public class l_552_2 {
	static int mod = 1000000007;
	public static int checkRecord(int n) {
		int[][][] cache = new int[n][2][3];
		return dfs(0, n, 0, 0, cache);
    }

	public static int dfs(int cur, int n, int a, int l, int[][][] cache) {
		if (cur >= n) {
			return 1;
		}
		
		if (cache[cur][a][l] > 0) {
			return cache[cur][a][l];
		}
		
		int ans = 0; 
		ans = (ans + dfs(cur + 1, n, a, 0, cache)) % mod;
		
		if (a < 1) {
			ans = (ans + dfs(cur + 1, n, 1, 0, cache)) % mod;
		}
		
		if (l < 2) {
			ans = (ans + dfs(cur + 1, n, a, l + 1, cache)) % mod;
		}
		
		cache[cur][a][l] = ans;
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		int n =10101;
		System.out.println(checkRecord(n));
	}
}
