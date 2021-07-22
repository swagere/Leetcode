package oneDay.offer;


//���������������
//����dp
//�ռ��Ż���ֱ����nums�ϸģ������⿪��dp�ռ�
public class o_42 {
	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] >= 0) {
				nums[i] = nums[i - 1] + nums[i];
			}
			max = Math.max(max, nums[i]);
		}
		
		return max;
    }


	public static void main(String[] args) {
		int[] nums = {-2,1};
		
		System.out.println(maxSubArray(nums));
	}

}
