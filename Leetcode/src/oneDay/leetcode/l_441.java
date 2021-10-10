package oneDay.leetcode;

//r
public class l_441 {
	public static int arrangeCoins(int n) {
        long sum = (long)n * 2;
        int i = (int) Math.sqrt(sum);
        while (true) {
            if ((long)i * (i + 1) >= sum) {
                break;
            } 
            i += 1;
        }
        if ((long)i * (i + 1) == sum) {
            return i;
        }
        return i - 1;
    }

	public static void main(String[] args) {
		int n = 2146467960;
		System.out.println(arrangeCoins(n));

	}

}
