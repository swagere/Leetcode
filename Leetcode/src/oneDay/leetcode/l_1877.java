package oneDay.leetcode;

import java.util.Arrays;

public class l_1877 {
	public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        
        int max = 0;
        for (int i = 0; i < nums.length / 2; i++) {
        	max = Math.max(max, nums[i] + nums[nums.length - 1 - i]);
        }
        return max;
    }

	public static void main(String[] args) {
		int[] nums = {4,1,5,1,2,5,1,5,5,4};
		System.out.println(minPairSum(nums));

	}

}
