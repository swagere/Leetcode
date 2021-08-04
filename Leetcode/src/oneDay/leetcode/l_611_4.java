package oneDay.leetcode;

import java.util.Arrays;

//r
//�Ż��������� ����֮�����
//+˫ָ��
//��������������±� �ҵ������ʹ�����������±�
public class l_611_4 {
	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums); //����
		
		int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		int k = j + 1;
        		while (k < nums.length && nums[i] + nums[j] > nums[k]) {
        			k++;
        		}
        		count += k - j - 1;
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		int[] nums = {0,0,0};

		System.out.println(triangleNumber(nums));
	}

}
