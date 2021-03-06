package oneDay.leetcode;

//r
//dp yyds!
//?Ӻ???ǰ
public class l_516_1 {
	public static int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] f = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			f[i][i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					f[i][j] = f[i + 1][j - 1] + 2;
				}
				else {
					f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]);
				}
			}
		}
		return f[0][n - 1];
    }

	public static void main(String[] args) {
		String s = "cbbd";
		
		System.out.println(longestPalindromeSubseq(s));
	}

}
