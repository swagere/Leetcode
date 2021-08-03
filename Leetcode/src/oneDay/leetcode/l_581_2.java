package oneDay.leetcode;

import java.util.Arrays;

//r
//先排好序 再对比
public class l_581_2 {

	public static int findUnsortedSubarray(int[] nums) {
		int low = -1;
		int high = -1;
		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (copy[i] != nums[i]) {
				low = i - 1;
				break;
			}
		}
		
		for (int i = nums.length - 1; i >= 0; i--) {
			if (copy[i] != nums[i]) {
				high = i + 1;
				break;
			}
		}
		
		if (high == -1 && low == -1) {
			return 0;
		}
		
		return high - low - 1;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		
		System.out.println(findUnsortedSubarray(nums));

	}

}
