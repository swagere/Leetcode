package oneDay.offer;

//r
//二分查找 + 有序数组
//二分查找单边再循环
public class o_53_2 {
	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = (left + right) / 2;
		int count = 0;
        while (left <= right) {
        	
        	if (target < nums[mid]) {
        		right = mid - 1;
        		mid = (left + right) / 2;
        	}
        	else if (target > nums[mid]) {
        		left = mid + 1;
        		mid = (left + right) / 2;
        	}
        	else {
        		break;
        	}
        	
        }
        
        for (int i = left; i <= right; i++) {
			if (nums[i] == target) {
				count++;
			}
			
			if (nums[i] != target && count != 0) {
				break;
			}
		}
        
        return count;
    }

	public static void main(String[] args) {
		int[] nums = {0};
		System.out.println(search(nums, 0));
	}

	
}
