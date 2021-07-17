package search;

//插值查找
//在递归二分的基础上修改
public class InsertValueSearch {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		
		int res = insertValueSearch(nums, 0, nums.length - 1, 1);
		if (res == -1) {
			System.out.println("没找到");
		}
		else {
			System.out.println(res);
		}
	}

	private static int insertValueSearch(int[] nums, int left, int right, int target) {
		System.out.println(1);
		if (left > right || nums[left] > target || nums[right] < target) {
			return -1;
		}
		
		int mid = left + (right - left) * (target - nums[left])/(nums[right] - nums[left]); 
		if (target < nums[mid]) {
			return insertValueSearch(nums, left, mid - 1, target);
		}
		else if (target > nums[mid]) {
			return insertValueSearch(nums, mid + 1, right, target);
		}
		else {
			return mid;
		}
	}

}
