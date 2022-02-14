package oneDay.offer;

public class o_10_Ⅰ {

	public static void main(String[] args) {
		System.out.println(Solution1013.fib(44));

	}

}
//递归+减少递归次数=记忆化递归
class Solution1011 {
	static int[] res;
	static int mod = 1000000007;
    public static int fib(int n) {
    	res = new int[n + 1];
    	return recursion(n);
    }
    
    public static int recursion(int n) {
    	if (n <= 1) {
    		res[n] = n;
    		return n;
    	}
    	if (res[n] != 0) {
    		return res[n];
    	}
    	int r = (recursion(n - 1) + recursion(n - 2)) % mod;
    	res[n] = r;
    	return r;
    }
}

//循环
class Solution1012 {
    public static int fib(int n) {
    	if (n <= 1) {
            return n;
        }
    	int[] res = new int[n + 1];
    	int mod = 1000000007;
    	res[0] = 0;
    	res[1] = 1;
    	for (int i = 2; i <= n; i++) {
    		res[i] = (res[i - 1] + res[i - 2]) % mod;
    	}
    	return res[n];
    }
}

//动态规划
class Solution1013 {
    public static int fib(int n) {
    	if (n <= 1) {
            return n;
        }
    	int mod = 1000000007;
    	int a = 0;
    	int b = 1;
    	int sum = a + b;
    	for (int i = 2; i < n; i++) {
    		a = b;
    		b = sum;
    		sum = (a + b) % mod;
    	}
    	return sum;
    }
}