package oneDay.leetcode;

import java.util.Arrays;

//r
//�Ż��������� ����֮�����
public class l_611_2 {
	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums); //����
		
		int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		for (int k = j + 1; k < nums.length; k++) {
        			if (nums[i] + nums[j] <= nums[k]) {
        				break;
        			}
        			else {
        				//������ߺͶ�С����һ��ֵ����˵�����߲�һ��С��
        				count += 1;
        			}
        		}
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		int[] nums = {2,2,3,4};

		System.out.println(triangleNumber(nums));
	}

}
