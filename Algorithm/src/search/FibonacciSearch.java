package search;

import java.util.Arrays;

//쳲������㷨
public class FibonacciSearch {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		
		int res = fibonacciSearch(nums, 3);
		if (res == -1) {
			System.out.println("û�ҵ�");
		}
		else {
			System.out.println(res);
		}

	}

	//쳲������㷨
	//���ֲ�����ѭ��ʵ��
	private static int fibonacciSearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		int k = 0; //�洢���ݸ����ҵ�������쳲�������
		
		//���쳲���������
		int[] f = fibonacci();
		
		while (right + 1 > f[k] - 1) {
			k++;
		}

		//���ԭ����
		//����Ϊ쳲������� ����쳲����������ҵ�midֵ
		int[] temp = Arrays.copyOf(nums, f[k]);
		for (int i = right + 1; i < f[k]; i++) {
			temp[i] = nums[right]; //��������Ԫ�ظ�Ϊԭ����������Ԫ�� ���������������
		}
		
		//ѭ��ʵ�ֶ���+쳲�����
		while (left <= right) {
			mid = left + f[k - 1] - 1;
			if (temp[mid] > target) {
				right = mid - 1;
				k--; //���Ϊf[k - 1]
			}
			else if (temp[mid] < target) {
				left = mid + 1;
				k -= 2; //�ұ�Ϊf[k + 1]
			}
			else {
				//�Ƚ�mid��length - 1��ֵ�����ظ�С���Ǹ�
				return Math.min(mid, nums.length - 1);
			}
			
		}
		
		return -1;
	}

	//���쳲���������
	private static int[] fibonacci() {
		int maxSize = 20;
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

}
