package oneDay.leetcode;


//超时
//dfs
public class l_552_1 {
	static int mod = 1000000007;
	public static int checkRecord(int n) {
		return dfs(0, n, 0, 0);
    }

	public static int dfs(int cur, int n, int a, int l) {
		if (cur >= n) {
			return 1;
		}
		
		int ans = 0; 
		ans = (ans + dfs(cur + 1, n, a, 0)) % mod;
		
		if (a < 1) {
			ans = (ans + dfs(cur + 1, n, 1, 0)) % mod;
		}
		
		if (l < 2) {
			ans = (ans + dfs(cur + 1, n, a, l + 1)) % mod;
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		int n = 2;
		System.out.println(checkRecord(n));
	}
}
