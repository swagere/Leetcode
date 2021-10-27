package oneDay.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l_229 {
	public static List<Integer> majorityElement(int[] nums) {
		int c = nums.length / 3;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	if (res.contains(nums[i])) {
        		continue;
        	}
        	Integer count = map.getOrDefault(nums[i], 0);
        	count += 1;
        	if (count > c) {
        		if (count > 1) {
        			map.remove(nums[i]);
        		}
        		res.add(nums[i]);
        	}
        	else {
        		map.put(nums[i], count);
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums = {1,1,1,3,3,2,2,2};
		System.out.println(majorityElement(nums));

	}

}
