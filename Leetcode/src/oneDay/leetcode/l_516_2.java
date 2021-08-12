package oneDay.leetcode;

//r
//dp yyds!
//从前到后
public class l_516_2 {
	public static int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] f = new int[n][n];
		for (int i = 0; i < n; i++) {
			f[i][i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j)) {
					f[i][j] = f[i - 1][j + 1] + 2;
				}
				else {
					f[i][j] = Math.max(f[i][j + 1], f[i - 1][j]);
				}
			}
		}
		return f[n - 1][0];
    }

	public static void main(String[] args) {
		String s = "bbbab";
		
		System.out.println(longestPalindromeSubseq(s));
	}

}
