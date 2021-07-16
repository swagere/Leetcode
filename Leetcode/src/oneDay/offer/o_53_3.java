package oneDay.offer;

//r
//二分查找 + 有序数组
//二分查找双边（单边优化）
//以搜索右边界为例：从第一次搜索到target值开始，向右搜索直到mid值不等于target找到右边界
public class o_53_3 {
	public static int search(int[] nums, int target) {
		//右边界
		int left = 0;
		int right = nums.length - 1;
		int mid = (left + right) / 2;
		//找到右边界
        while (left <= right) {
        	if (target < nums[mid]) {
        		right = mid - 1;
        		mid = (left + right) / 2;
        	}
        	else if (target >= nums[mid]) {
        		left = mid + 1;
        		mid = (left + right) / 2;
        	}
        }
        System.out.println(left);
        System.out.println(right);
        System.out.println(mid);
        System.out.println();
        int r = left; 
        
        //提前返回
        if (nums.length == 0 || nums[mid] != target) {
        	return 0;
        }
        
        //左边界
        left = 0;
        right = nums.length - 1;
		mid = (left + right) / 2;
		//找到左边界
        while (left <= right) {
        	
        	if (target <= nums[mid]) {
        		right = mid - 1;
        		mid = (left + right) / 2;
        	}
        	else {
        		left = mid + 1;
        		mid = (left + right) / 2;
        	}
        }
        int l = right;
        System.out.println(left);
        System.out.println(right);
        System.out.println(mid);
        System.out.println();

        return r - l - 1;
    }

	public static void main(String[] args) {
		int[] nums = {5,7,8,8,8,9};
		System.out.println(search(nums, 8));
	}

	
}
