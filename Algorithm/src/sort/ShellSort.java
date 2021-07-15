package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//1. ����
//2. ��λ
public class ShellSort {

	public static void main(String[] args) {
		int[] nums = {1,0,4,3,-1,5};
		System.out.println(Arrays.toString(nums));
		
		shellSort2(nums);
		System.out.println(Arrays.toString(nums));

//		int[] nums = new int[80000];
//		for (int i = 0; i < 80000; i++) {
//			nums[i] = (int) (Math.random()*800000);
//		}
//		
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date1 = new Date();
//		System.out.println(simpleDateFormat.format(date1));
//		
//		shellSort1(nums);
//		
//		Date date2 = new Date();
//		System.out.println(simpleDateFormat.format(date2));
	}


	//������
	private static void shellSort1(int[] nums) {
		for (int i = nums.length / 2; i > 0; i = i / 2) {
			int temp = 0;
			for (int j = i; j < nums.length; j++) {
				for (int k = j - i; k >= 0; k -= i) { //ÿ�ζ������������е�����Ԫ��
					if (nums[k + i] < nums[k]) {
						temp = nums[k + i];
						nums[k + i] = nums[k];
						nums[k] = temp;
					}
					//�Ż�
					else {
						break;
					}
				}
			}
		}
		
	}
	

	//��λ��
	private static void shellSort2(int[] nums) {
		for (int i = nums.length / 2; i > 0; i /= 2) {
			for (int j = i; j < nums.length; j++) {
				//��λ�� ��ֱ�Ӳ��������е���λ˼��
				int insertValue = nums[j];
				int insertIndex = j - i;
				
				while (insertIndex >= 0 && insertValue < nums[insertIndex]) {
					nums[insertIndex + i] = nums[insertIndex];
					insertIndex -= i;
				}
				
				if (insertIndex != j - i) {
					nums[insertIndex + i] = insertValue; 
				}
			}
		}
		
	}

}
