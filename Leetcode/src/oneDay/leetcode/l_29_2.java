package oneDay.leetcode;

//w
//´íÎó
public class l_29_2 {
	public static int divide(int dividend, int divisor) {
        boolean flag = true;
        if ((long)dividend * divisor < 0) {
        	flag = false;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long res = 1;
        
        if (a < b) {
        	return 0;
        }
        if (a >= b) {
        	res = doubleNum(b, 1, a, b);
        }
        
        if (flag == false) {
        	res = -res;
        }
        
        if (res > Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        }
        
        return (int) res;
    }
	
	public static long doubleNum(long num, long count, long dividend, long divisor) {
		if (num == dividend) {
			return count;
		}
		else if (num > dividend &&  num <= divisor + dividend) {
			return count - 1;
		}
		else if (num > dividend &&  num > divisor + dividend) {
			return doubleNum(num - divisor, count - 1, dividend, divisor);
		}
		else {
			return doubleNum(num + num, count + count, dividend, divisor);
		}
	}

	public static void main(String[] args) {
		int dividend = 2147483647;
		int divisor = 3;
		System.out.println(divide(dividend, divisor));
	}

}
