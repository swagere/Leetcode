package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {
//		int[] nums = {0,1,3,4,-1,2,-2};
		int[] nums = new int[80000];
		for (int i = 0; i < 80000; i++) {
			nums[i] = (int) (Math.random()*800000);
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date1 = new Date();
		System.out.println(simpleDateFormat.format(date1));
//		System.out.println(Arrays.toString(nums));
		
		selectSort(nums);
//		System.out.println(Arrays.toString(nums));
		Date date2 = new Date();
		System.out.println(simpleDateFormat.format(date2));
		

	}

	//Ñ¡ÔñÅÅÐò
	private static void selectSort(int[] nums) {
		int min;
		int index;
		int temp;
		for (int i = 0; i < nums.length - 1; i++) {
			min = nums[i];
			index = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (min > nums[j]) {
					min = nums[j];
					index = j;
				}
			}
			
			//½»»»
			if (index != i) {
				temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
			}
		}
		
	}

}
