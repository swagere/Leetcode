package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//√∞≈›≈≈–Ú
public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = new int[80000];
		for (int i = 0; i < 80000; i++) {
			nums[i] = (int) (Math.random()*800000);
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date1 = new Date();
		System.out.println(simpleDateFormat.format(date1));
//		System.out.println(Arrays.toString(nums));
		
		bubbleSort(nums);
		Date date2 = new Date();
		System.out.println(simpleDateFormat.format(date2));
//		System.out.println(Arrays.toString(nums));
	}
	
	public static void bubbleSort(int[] nums) {
		int temp = 0;
		boolean flag = false;
		for (int i = 1; i < nums.length; i++) {
			flag = false;
			for (int j = 0; j < nums.length - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					flag = true;
				}
			}
			
			//”≈ªØ
			if (flag == false) {
				break;
			}
		}
	}

}
