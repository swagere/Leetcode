package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//ֱ�Ӳ�������
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

	//ֱ�Ӳ�������
	private static void insertSort(int[] nums) {
		//n-1��ѭ��
		int insertValue;
		int insertIndex;
		for (int i = 1; i < nums.length; i++) {
			insertIndex = i - 1;
			insertValue = nums[i];
			
			while (insertIndex >= 0 && insertValue < nums[insertIndex]) {
				//����
				nums[insertIndex + 1] = nums[insertIndex];

				insertIndex--;
			}
			
			//�Ż������ж��ٸ�ֵ
			if (insertIndex != i - 1) {
				nums[insertIndex + 1] = insertValue;
			}
			

		}
		
	}

}
