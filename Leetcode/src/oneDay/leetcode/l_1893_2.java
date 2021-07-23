package oneDay.leetcode;

import java.util.Arrays;


//r
//1. 排序 
//2. 依次移动left 当left>right 说明已经全部被覆盖
public class l_1893_2 {
	public static boolean isCovered(int[][] ranges, int left, int right) {
		Arrays.sort(ranges, (a,b)->{return a[0] - b[0];});
//		System.out.println(Arrays.toString(ranges[0]));
		for (int[] item : ranges) {
			if (item[0] >= left && item[1] <= left) {
				left = item[1] + 1;
			}
			
			if (left > right) {
				return true;
			}
		}
		
		return false;
    }

	public static void main(String[] args) {
//		int[][] ranges = {{1,2},{3,4},{5,6}};
		int[][] ranges = {{1,10},{10,20}};
		int left = 21;
		int right = 21;
		System.out.println(isCovered(ranges, left, right));
	}

}
