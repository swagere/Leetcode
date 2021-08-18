package oneDay.leetcode;


//r
//dp!!!
public class l_552_3 {
	static int mod = 1000000007;
	public static int checkRecord(int n) {
		long[][][] cache = new long[n][2][3];
		cache[0][0][0] = 1;
		cache[0][1][0] = 1;
		cache[0][0][1] = 1;
		
		for (int i = 1; i < n; i++) {
			//p
			cache[i][0][0] = (cache[i - 1][0][0] + cache[i - 1][0][1] + cache[i - 1][0][2] + mod) % mod;
			cache[i][1][0] = (cache[i - 1][1][0] + cache[i - 1][1][1] + cache[i - 1][1][2] + mod) % mod;
			
			//a
			cache[i][1][0] = (cache[i][1][0] + cache[i - 1][0][0] + cache[i - 1][0][1] + cache[i - 1][0][2] + mod) % mod;
			
			//l
			cache[i][0][1] = cache[i - 1][0][0];
			cache[i][0][2] = cache[i - 1][0][1];
			cache[i][1][1] = cache[i - 1][1][0];
			cache[i][1][2] = cache[i - 1][1][1];
		}
		
		return (int) ((cache[n - 1][0][0] + cache[n - 1][1][0] + cache[n - 1][0][1] + cache[n - 1][0][2] + cache[n - 1][1][1] + cache[n - 1][1][2] + mod) % mod);
    }
	
	
	public static void main(String[] args) {
		int n = 10101;
		System.out.println(checkRecord(n));
	}
}
