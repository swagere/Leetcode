package oneDay.leetcode;

import java.util.Arrays;

//r
//�Ż��������� ����֮�����
//�ö��ַ����� ����һ��һ������
public class l_611_3 {
	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums); //����
		
		int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		int l = j + 1;
        		int r = nums.length - 1;
        		int target = nums[i] + nums[j];
        		
        		//���ַ�
        		while (l <= r) {
        			int mid = (l + r) / 2;
        			if (nums[mid] < target) {
        				l = mid + 1;
        			}
        			else {
        				r = mid - 1;
        			}
        		}

        		count += r - j;
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		int[] nums = {2,2,3,4};

		System.out.println(triangleNumber(nums));
	}

}
