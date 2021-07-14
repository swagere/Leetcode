package recursion;

//八皇后问题
//递归解决
public class queen {

	//记录走过的步数
	//将二维数组转化为一维数组
	//全局变量
	static int[] step = new int[8];
	
	//表示皇后数量
	static int max = 8;
	
	//记录成功次数
	static int count = 0;
	
	public static void main(String[] args) {
		recursion(0);
		System.out.println(count);
	}

	//返回可能情况的种类数
	private static void recursion(int n) {
		if (n == max) {
			count++;
			return;
		}
		for (int i = 0; i < max; i++) {
			if (check(n, i)) {
				step[n] = i;
				recursion(n + 1);
			}
		}
	}

	//判断是否冲突：是否在同一行、同一列、同一斜线
	private static boolean check(int n, int i) {
		for (int j = 0; j < n; j++) {
			if (step[j] == i || Math.abs(n - j) == Math.abs(i - step[j])) { //abs
				return false;
			}
		}
		return true;
	}
}
