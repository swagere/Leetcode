package sort;

import java.util.Arrays;

//��������
//���ܴ�������������ͬ�����
public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {9,0,-1,-22,4,10,-4};
		
		quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));

	}

	//����
	private static void quickSort(int[] nums, int left, int right) {
		int l = left;
		int r = right;
		int pivot = nums[(l + r) / 2];
		
		int temp = 0;
		//������Ĳ��ְ��� �����pivotֵ���ұ� С����pivotֵ����� ����
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
