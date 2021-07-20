package oneDay.leetcode;

import java.util.Arrays;

//r
//�������ڻ��ƽ��
//�������k����߼�
//���С��k���ұ߼�
//���൱���������� ÿ��Ԫ�صĲ����������ǰ��Ԫ�ؿ�����ȵ������� 
public class l_1838_2 {
	public static int maxFrequency(int[] nums, int k) {
		//������
		Arrays.sort(nums);
		
		
		int l = 0;
		int r = 1;
		
		int sum = 0;
		int max = 1;
		
		//��������
		while (r < nums.length) {
			sum += (r - l) * (nums[r] - nums[r - 1]);// ����*��ֵ ��������ֵ������Ϊ��rֵ��ȵ�ֵ ��ʵ��ֵû�иı�
			
			while (sum > k && l < r) {
				//�������
				sum -= nums[r] - nums[l];
				l++;
			}
			
			max = Math.max(max, r - l + 1);
			
			
			r++;
		}
		
		return max;
    }

	public static void main(String[] args) {
		int[] nums = {3,9,6};
		int k = 2;
		
		System.out.println(maxFrequency(nums, k));
	}

}
