package oneDay.leetcode;


//r
//差分数组：得到每个数出现次数
public class l_1893_3 {
	public static boolean isCovered(int[][] ranges, int left, int right) {
		int[] diff = new int[52];
		//先遍历 给首 尾+1 赋值
		for (int[] item : ranges) {
			diff[item[0]] += 1;
			diff[item[1] + 1] += -1;
		}
		
		//再求前缀和
		for (int i = 1; i < diff.length; i++) {
			diff[i] += diff[i - 1];
		}
		
		for (int i = left; i <= right; i++) {
			if (diff[i] <= 0) {
				return false;
			}
		}
		
		return true;
    }

	public static void main(String[] args) {
//		int[][] ranges = {{1,2},{3,4},{5,6}};
		int[][] ranges = {{1,10},{10,20}};
		int left = 21;
		int right = 21;
		System.out.println(isCovered(ranges, left, right));
	}

}
