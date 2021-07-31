package binarysearch;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {11};
		int target = 11;

		int res = cyclicBinarySearch(0, nums.length - 1, target, nums);
		if (res == -1) {
			System.out.println("Î´ÕÒµ½");
		}
		else {
			System.out.println(res);
		}
	}

	//µİ¹é
	private static int recusionBinarySearch(int left, int right, int target, int[] nums) {
		if (left > right) {
			return -1;
		}
		int l = left;
		int r = right;
		int mid = (l + r) / 2;
		int temp = nums[mid];
		
		if (temp > target) {
			r = mid - 1;
		}
		else if (temp < target){
			l = mid + 1;
		}
		else {
			return mid;
		}
		
		return recusionBinarySearch(l, r, target, nums);
	}

	
	//Ñ­»·
	public static int cyclicBinarySearch(int left, int right, int target, int[] nums) {
		int l = left;
		int r = right;
		
		
		while (l <= r) {
			int mid = (l + r) / 2;
			int temp = nums[mid];
			if (temp > target) {
				r = mid - 1;
			}
			else if (temp < target){
				l = mid + 1;
			}
			else {
				return mid;
			}
		}
		
		return -1;
	}
}
