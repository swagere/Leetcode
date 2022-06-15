package oneDay.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class l_532 {

	public static void main(String[] args) {
		int[] nums = {3,1,4,1,5};
		int k = 2;
		System.out.println(new Solution5322().findPairs(nums, k));

	}

}

//排序  + 双指针
//优化：排序 + 二分
class Solution5321 {
    public int findPairs(int[] nums, int k) {
    	Arrays.sort(nums);
    	int sum = 0;
    	int len = nums.length;
    	for (int i = 0; i < len - 1; i++ ) {
    		if (i > 0) {
    			if (nums[i] == nums[i - 1]) {
    				continue;
    			}
    		}
    		
    		for (int j = i + 1; j < len; j++) {
    			if (nums[j] - nums[i] == k) {
    				sum += 1;
    				break;
    			}
    			else if (nums[j] - nums[i] > k) {
    				break;
    			}
    		}
    	}
    	return sum;
    }
}

//哈希表
class Solution5322 {
    public int findPairs(int[] nums, int k) {
    	Set<Integer> set = new HashSet<Integer>();
    	Set<Integer> res = new HashSet<Integer>(); // 记录较小值
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (set.contains(nums[i] - k) && !res.contains(nums[i] - k)) {
    			sum += 1;
    			res.add(nums[i] - k);
    		}
    		if (set.contains(nums[i] + k) && !res.contains(nums[i])) {
    			sum += 1;
    			res.add(nums[i]);
    		}
    		
    		set.add(nums[i]);
    	}
    	return sum;
    }
}