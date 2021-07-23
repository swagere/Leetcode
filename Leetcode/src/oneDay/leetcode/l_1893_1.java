package oneDay.leetcode;

//import java.util.Arrays;

//r
//暴力
//标记每段的值 最后在要求区间内遍历 若所有节点都被标记则说明
//优化：只需要标记left和right之间的值
public class l_1893_1 {
	public static boolean isCovered(int[][] ranges, int left, int right) {
		int[] covered = new int[right + 1];
		for (int[] item : ranges) {
			for (int i = item[0]; i <= item[1]; i++) {
				//从left开始
				if (i < left) {
					if (left > item[1]) {
						i = left - 1;
						continue;
					}
				}
				
				//到right结束
				if (i <= right) {
					covered[i]++;
				}
				else {
					break;
				}
			}
		}
		
//		System.out.println(Arrays.toString(covered));
		
		
		for (int i = left; i <= right; i++) {
			if (covered[i] <= 0) {
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
