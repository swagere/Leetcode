package oneDay.leetcode;

import java.util.Arrays;

public class l_1846 {
	public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		Arrays.sort(arr);
		arr[0] = 1;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] > 1) {
				arr[i] = arr[i - 1] + 1;
			}
		}
		
		return arr[arr.length - 1];
    }

	public static void main(String[] args) {
		int[] arr = {2,2,1,2,1};
		System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
	}

}
