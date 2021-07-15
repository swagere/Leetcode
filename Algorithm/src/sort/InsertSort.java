package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//直接插入排序
public class InsertSort {

	public static void main(String[] args) {
//		int[] nums = {1,3,2,4,3,-1};
		
		int[] nums = new int[80000];
		for (int i = 0; i < 80000; i++) {
			nums[i] = (int) (Math.random()*800000);
		}
		
//		System.out.println(Arrays.toString(nums));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = new Date();
		System.out.println(simpleDateFormat.format(date1));
		
		insertSort(nums);
//		System.out.println(Arrays.toString(nums));
		Date date2 = new Date();
		System.out.println(simpleDateFormat.format(date2));
	}

	//直接插入排序
	private static void insertSort(int[] nums) {
		//n-1次循环
		int insertValue;
		int insertIndex;
		for (int i = 1; i < nums.length; i++) {
			insertIndex = i - 1;
			insertValue = nums[i];
			
			while (insertIndex >= 0 && insertValue < nums[insertIndex]) {
				//后移
				nums[insertIndex + 1] = nums[insertIndex];

				insertIndex--;
			}
			
			//优化：先判断再赋值
			if (insertIndex != i - 1) {
				nums[insertIndex + 1] = insertValue;
			}
			

		}
		
	}

}
