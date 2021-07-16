package sort;

import java.util.Arrays;

//归并排序
//递归实现
public class MergeSort {

	public static void main(String[] args) {
		int[] nums = {1,4,5,6,3,2,-1};
		
		mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	//递归实现
	//分的递归 
	//调用合
	private static void mergeSort(int[] nums, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			//先做左边递归
			mergeSort(nums, left, mid);
			
			//再做右边递归
			mergeSort(nums, mid + 1, right);
			
			//合
			merge(nums, left, mid, right);
		}
		
	}

	//合
	private static void merge(int[] nums, int left, int mid, int right) {
		int[] temp = new int[nums.length];
		int l = left;
		int r = mid + 1;
		int index = 0;

		//给temp赋值
		while (l <= mid && r <= right) {
			if (nums[l] < nums[r]) {
				temp[index] = nums[l];
				l++;
				index++;
			}
			else {
				temp[index] = nums[r];
				r++;
				index++;
			}
		}
		
		//将剩余元素放入temp
		while (l <= mid) {
			temp[index] = nums[l];
			l++;
			index++;
		}
		while (r <= right) {
			temp[index] = nums[r];
			r++;
			index++;
		}
		
		//将temp赋值给原数组nums
		index = 0;
		l = left;
		while (l <= right) {
			nums[l] = temp[index];
			l++;
			index++;
		}
	}

}
