package sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] nums = {1,5,-1,36,0,132,365,465645,2,-213};
		
		heapSort(nums);
		System.out.println(Arrays.toString(nums));

	}

	//������
	//�Դ�С����Ϊ�� ʹ�ô󶥶�
	private static void heapSort(int[] nums) {
		//�Ƚ���һ������ ���������黯�������
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			//�ӵ�һ����Ҷ�ӽڵ㿪ʼ��
			adjustHeap(nums, i, nums.length);
		}
		
		for (int i = nums.length - 1; i > 0; i--) {
			//�����һ�����ź���ĵ�һ�����ֵ����
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			
			//�·�Χ������ѭ�� ��ʱֻ��ѭ����� ��ֻ��Ҫ����˵ķ��ں���λ�ü���
			adjustHeap(nums, 0, i);
		}
		
	}
	
	//ÿ�ε�����
	//iΪ��Ҫ�����λ��
	public static void adjustHeap(int[] nums, int index, int length) {
		//�൱�ڲ���������һ������λ
		int temp = nums[index]; //Ҫ�ŵ�λ��
		
		//�������ӽڵ�
		for (int i = 2 * index + 1; i < length; i = 2 * index + 1) { // ��һ�ּ�������һ���������ӽڵ�
			//�����ӽڵ�Ƚ� �����ϴ����
			if (i + 1 < length && nums[i] < nums[i + 1]) { //���i+1�Ĵ�С
				i += 1;
			}
			
			//�Ƚϸ��ڵ�
			if (nums[i] > temp) {
				nums[index] = nums[i];
				index = i;
			}
			else {
				break;
			}
		}
		
		//��temp�������ź������ȷλ��
		nums[index] = temp;
	}

}
