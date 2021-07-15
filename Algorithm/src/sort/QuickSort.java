package sort;

import java.util.Arrays;

//快速排序
//不能处理有两个数相同的情况
public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {9,0,-1,-22,4,10,-4};
		
		quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));

	}

	//快排
	private static void quickSort(int[] nums, int left, int right) {
		int l = left;
		int r = right;
		int pivot = nums[(l + r) / 2];
		
		int temp = 0;
		//将输入的部分按照 大的在pivot值的右边 小的在pivot值的左边 排序
		while (l < r) {
			while (nums[l] < pivot) {
				l++;
			}
			
			while (nums[r] > pivot) {
				r--;
			}
			
			if (l >= r) {
				break;
			}
			
			temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			
			if (nums[l] == pivot) {
				r--;
			}
			if (nums[r] == pivot) {
				l++;
			}
			
			
		}
		
		if (l == r) {
			l++;
			r--;
		}
		
		if (left < r) {
			quickSort(nums, left, r);
		}
		
		if (right > l) {
			quickSort(nums, l, right);
		}
		
		
	}

}
