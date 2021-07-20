package oneDay.leetcode;

import java.util.Arrays;

//r
//滑动窗口机制解决
//如果大于k就左边减
//如果小于k就右边加
//即相当于算出排序后 每个元素的不超过自身的前面元素可能相等的最大次数 
public class l_1838_2 {
	public static int maxFrequency(int[] nums, int k) {
		//先排序
		Arrays.sort(nums);
		
		
		int l = 0;
		int r = 1;
		
		int sum = 0;
		int max = 1;
		
		//滑动窗口
		while (r < nums.length) {
			sum += (r - l) * (nums[r] - nums[r - 1]);// 个数*差值 假设所有值都被化为与r值相等的值 但实际值没有改变
			
			while (sum > k && l < r) {
				//左边缩减
				sum -= nums[r] - nums[l];
				l++;
			}
			
			max = Math.max(max, r - l + 1);
			
			
			r++;
		}
		
		return max;
    }

	public static void main(String[] args) {
		int[] nums = {3,9,6};
		int k = 2;
		
		System.out.println(maxFrequency(nums, k));
	}

}
