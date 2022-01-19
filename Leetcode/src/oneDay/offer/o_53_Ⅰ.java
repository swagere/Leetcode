package oneDay.offer;

public class o_53_Ⅰ {

	public static void main(String[] args) {
		int[] nums = {1};
		int target = 1;
		System.out.println(Solution533.search(nums, target));
	}

}

//顺序查找
class Solution531 {
    public static int search(int[] nums, int target) {
    	int times = 0;
    	int i = 0;
		while (i < nums.length && nums[i] < target) {
			i++;
		}
		times = i;
		while (i < nums.length && nums[i] == target) {
			i++;
		}
    	return i - times;
    }
}

//二分查找
class Solution532 {
	public static int search(int[] nums, int target) {
    	int left = 0;
    	int right = nums.length - 1;
    	int mid = 0;
    	while (left < right) {
    		mid = (left + right) / 2;
    		if (nums[mid] < target) {
    			left = mid + 1;
    		}
    		else {
    			right = mid;
    		}
    	}
    	int times = 0;
    	while (mid < nums.length && nums[mid] < target) {
    		mid += 1;
    	}
    	while (mid < nums.length && nums[mid] == target) {
    		times += 1;
    		mid ++;
    	}
    	return times;
    }
}

//两次二分法
class Solution533 {
	public static int search(int[] nums, int target) {
    	int left = 0;
    	int right = nums.length - 1;
    	int mid = 0;
    	while (left <= right) {
    		mid = (left + right) / 2;
    		if (nums[mid] < target) {
    			left = mid + 1;
    		}
    		else {
    			right = mid - 1;
    		}
    	}
    	int l = left;
    	
    	if (l >= 0 && l < nums.length && nums[l] != target) {
    		return 0;
    	}
    	
    	
    	left = l;
    	right = nums.length - 1;
    	mid = 0;
    	while (left <= right) {
    		mid = (left + right) / 2;
    		if (nums[mid] <= target) {
    			left = mid + 1;
    		}
    		else {
    			right = mid - 1;
    		}
    	}
    	int r = left;
    	return r - l;
    }
}