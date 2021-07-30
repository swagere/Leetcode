package oneDay.leetcode;

//r
//26½øÖÆ
public class l_171 {
	public static int titleToNumber(String columnTitle) {
		int res = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			res += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - 1 - i);
		}
		return res;
    }

	public static void main(String[] args) {
		String columnTitle = "FXSHRXW";
		System.out.println(titleToNumber(columnTitle));
	}

}
