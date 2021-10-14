package oneDay.leetcode;

//w
//³¬Ê±
public class l_29_1 {
	public static int divide(int dividend, int divisor) {
        boolean flag = true;
        long a = dividend;
        long b = divisor;
        if (a * b < 0) {
            flag = false;
        }
        a = Math.abs(a);
        b = Math.abs(b);

        long count = 0;
        while (a >= b) {
            a -= b;
            count += 1;
            if (count == Integer.MAX_VALUE && flag == true) {
            	break;
            }
        }

        if (flag == false) {
            count = -1 * count;
        }
        return (int) count;
    }

	public static void main(String[] args) {
		int dividend = 2147483647;
		int divisor = 1;
		System.out.println(divide(dividend, divisor));
	}

}
