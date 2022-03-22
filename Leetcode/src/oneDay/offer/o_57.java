package oneDay.offer;

import java.util.Arrays;

public class o_57 {

	public static void main(String[] args) {
		int[] nums = {2,7,11,17};
		System.out.println(Arrays.toString(Solution571.twoSum(nums, 9)));

	}

}

//双指针
class Solution571 {
    public static int[] twoSum(int[] nums, int target) {
    	int left = 0;
        int right = nums.length - 1;
        while (left < right) {
        	if (nums[left] + nums[right] > target) {
        		right -= 1;
        	}
        	else if (nums[left] + nums[right] < target){
        		left += 1;
        	}
        	else {
        		return new int[] {nums[left], nums[right]};
        	}
        }
        return null;
    }
}

//二分+双指针
class Solution572 {
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //二分法找到中间值所在位置
        while (left <= right) {
        	int mid = (left + right) / 2;
        	if (nums[mid] > target / 2) {
        		right = mid - 1;
        	}
        	else {
        		left = mid + 1;
        	}
        }
        
        int l = 0;
        int r = nums.length;
        if (nums[right] * 2 < target) {
        	l = right;
        	r = right + 1;
        }
        else {
        	l = right - 1;
        	r = right + 1;
        }
        
        while (l >= 0 && r < nums.length) {
        	if (nums[l] + nums[r] < target) {
        		r += 1;
        	}
        	else if (nums[l] + nums[r] > target){
        		l -= 1;
        	}
        	else {
        		return new int[] {nums[l], nums[r]};
        	}
        }
        
        return null;
    }
}