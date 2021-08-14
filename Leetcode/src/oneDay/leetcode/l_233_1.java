package oneDay.leetcode;


//超时
public class l_233_1 {
	public static int countDigitOne(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int cur = 0;
			
			//加上目前的
			int temp = i;
			while (temp > 9) {
				if (temp % 10 == 1) {
					cur += 1;
				}
				temp = temp / 10;
			}
			if (temp == 1) {
				cur += 1;
			}
			
			
			count = count + cur;
		}
		return count;
	}

	public static void main(String[] args) {
		int n = 13;
		System.out.println(countDigitOne(n));
	}

}
