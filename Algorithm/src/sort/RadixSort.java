package sort;

import java.util.Arrays;

//��������
public class RadixSort {

	public static void main(String[] args) {
		int[] nums = {1,12,24,26,9,0,4,3,2};
		
		radixSort(nums);
		System.out.println(Arrays.toString(nums));

	}

	//�������� ѭ��ʵ��
	private static void radixSort(int[] nums) {
		//ÿ������ʱ��Ҫ��Ͱ
		int[][] bucket = new int[10][nums.length];
		
		//ÿ���������
		int[] bucketElementCounts = new int[10];
		
		//��������Ҫ������ �������������λ��
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		int maxLength = String.valueOf(max).length();//���ټ���λ��
		
		//ѭ�� ��������
		//�Ӹ�λ��ʼ�����λ
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			//�����ݷ���Ͱ��
			for (int j = 0; j < nums.length; j++) {
				int digit = (nums[j] / n) % 10;
				bucket[digit][bucketElementCounts[digit]] = nums[j];
				bucketElementCounts[digit] += 1;
			}
				
				
			//��Ͱ��ȡ������
			int index = 0;
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < bucketElementCounts[j]; k++) {
					nums[index] = bucket[j][k];
					index++;
				}
				
				//��bucketElementCounts[j]��Ϊ0 ��ԭ
				bucketElementCounts[j] = 0;
			}
			
			
			
		}


		
	}

}
