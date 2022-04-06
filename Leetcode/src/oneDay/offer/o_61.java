package oneDay.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class o_61 {

	public static void main(String[] args) {
		int[] nums = {0,0,1,2,5};
		System.out.println(new Solution612().isStraight(nums));
	}

}

//排序+计数
class Solution611 {
    public boolean isStraight(int[] nums) {
    	Arrays.sort(nums);
    	int count = 0;
    	for (int i = 0; i < nums.length - 1; i++) {
    		if (nums[i] == 0) {
    			count += 1;
    			continue;
    		}
    		if (nums[i + 1] - nums[i] > 1) {
    			count -= nums[i + 1] - nums[i] - 1;
    		}
    		else if (nums[i + 1] - nums[i] == 0) {
    			return false;
    		}
    		if (count < 0) {
    			return false;
    		}
    	}
    	return true;
    }
}

//判重 最大最小差值
class Solution612 {
    public boolean isStraight(int[] nums) {
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	Set<Integer> repeat = new HashSet<>();
    	for (int i : nums) {
    		if (i == 0) {
    			continue;
    		}
    		if (i > max) max = i;
    		if (i < min) min = i;
    		if (repeat.contains(i)) return false;
    		repeat.add(i);
    	}
    	
    	return max - min < 5;
    }
}