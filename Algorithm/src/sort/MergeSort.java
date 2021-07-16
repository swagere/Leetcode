package sort;

import java.util.Arrays;

//�鲢����
//�ݹ�ʵ��
public class MergeSort {

	public static void main(String[] args) {
		int[] nums = {1,4,5,6,3,2,-1};
		
		mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	//�ݹ�ʵ��
	//�ֵĵݹ� 
	//���ú�
	private static void mergeSort(int[] nums, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			//������ߵݹ�
			mergeSort(nums, left, mid);
			
			//�����ұߵݹ�
			mergeSort(nums, mid + 1, right);
			
			//��
			merge(nums, left, mid, right);
		}
		
	}

	//��
	private static void merge(int[] nums, int left, int mid, int right) {
		int[] temp = new int[nums.length];
		int l = left;
		int r = mid + 1;
		int index = 0;

		//��temp��ֵ
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
		
		//��ʣ��Ԫ�ط���temp
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
		
		//��temp��ֵ��ԭ����nums
		index = 0;
		l = left;
		while (l <= right) {
			nums[l] = temp[index];
			l++;
			index++;
		}
	}

}
