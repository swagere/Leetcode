package search;

//二分查找
//递归/循环实现
public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		
		int res = binarySearch2(nums, 0, nums.length - 1, 1);
		if (res == -1) {
			System.out.println("没有找到该数");
		}
		else {
			System.out.println(res);
		}
		
	}

	//递归实现
	private static int binarySearch1(int[] nums, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		
		int mid = (left + right) / 2;
		if (target > nums[mid]) {
			return binarySearch1(nums, mid + 1, right, target);
		}
		else if (target < nums[mid]) {
			return binarySearch1(nums, left, mid - 1, target);
		}
		
		return mid;
		
	}

	//循环实现
	private static int binarySearch2(int[] nums, int left, int right, int target) {
		
		int mid = (left + right) / 2;
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
		
		if (left > right) {
			return -1;
		}
		
		return mid;
	}
}
