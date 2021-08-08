package oneDay.leetcode;

//r
//动态规划
//在循环的基础上 改成只有三个值来存数据即可（因为只需要三个值 不需要其他值
public class l_1137_3 {
	public static int tribonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		
		int a = 0;
		int b = 1;
		int c = 1;
		int d = 0;
		for (int i = 3; i <= n; i++) {
			d = a + b + c;
			a = b;
			b = c;
			c = d;
		}
        
        return d;
    }

	public static void main(String[] args) {
		int n = 35;
		System.out.println(tribonacci(n));

	}

}
