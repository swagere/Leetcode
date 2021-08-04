package oneDay.leetcode;

import java.util.Arrays;

//r
//优化：先排序 排序之后遍历
public class l_611_2 {
	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums); //排序
		
		int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		for (int k = j + 1; k < nums.length; k++) {
        			if (nums[i] + nums[j] <= nums[k]) {
        				break;
        			}
        			else {
        				//如果两者和都小于另一个值，则说明两者差一定小于
        				count += 1;
        			}
        		}
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		int[] nums = {2,2,3,4};

		System.out.println(triangleNumber(nums));
	}

}
