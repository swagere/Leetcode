package sort;

import java.util.Arrays;

//基数排序
public class RadixSort {

	public static void main(String[] args) {
		int[] nums = {1,12,24,26,9,0,4,3,2};
		
		radixSort(nums);
		System.out.println(Arrays.toString(nums));

	}

	//基数排序 循环实现
	private static void radixSort(int[] nums) {
		//每次排序时需要的桶
		int[][] bucket = new int[10][nums.length];
		
		//每次排序计数
		int[] bucketElementCounts = new int[10];
		
		//排序所需要的轮数 先求出最大的数的位数
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		int maxLength = String.valueOf(max).length();//快速计算位数
		
		//循环 基数排序
		//从个位开始到最高位
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			//将数据放入桶中
			for (int j = 0; j < nums.length; j++) {
				int digit = (nums[j] / n) % 10;
				bucket[digit][bucketElementCounts[digit]] = nums[j];
				bucketElementCounts[digit] += 1;
			}
				
				
			//从桶中取出数据
			int index = 0;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < bucketElementCounts[j]; k++) {
					nums[index] = bucket[j][k];
					index++;
				}
				
				//将bucketElementCounts[j]置为0 还原
				bucketElementCounts[j] = 0;
			}
			
			
			
		}


		
	}

}
