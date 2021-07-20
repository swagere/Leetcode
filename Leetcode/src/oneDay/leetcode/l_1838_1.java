package oneDay.leetcode;

import java.util.Arrays;

//优化1：先排序
//优化2：从i往回检查
//r
public class l_1838_1 {
	public static int maxFrequency(int[] nums, int k) {
		int max = 1;
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
				continue; // 跳过重复值
			}
				
			int count = 0;
			int sum = 0;
			
			for (int j = i - 1; j >= 0; j--) { // 从i往回检查
				sum += nums[i] - nums[j];
				if (sum > k) {
					break;
				}
				else if (sum == k) {
					count++;
					break;
				}
				count += 1;
			}
			
			max = Math.max(max, count + 1);
			
		}
		
		return max;
    }

	public static void main(String[] args) {
		int[] nums = {1,2,4};
		int k = 5;
		
		System.out.println(maxFrequency(nums, k));
	}

}
