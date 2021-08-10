package oneDay.leetcode;

//r
//˫ָ��
public class l_413 {
	public static int numberOfArithmeticSlices(int[] nums) {
		int i = 0;
		int j = 1;
		int count = 0;
		while (j < nums.length - 1) {
			while (j + 1 < nums.length && nums[j] - nums[i] != nums[j + 1] - nums[j]) {
				i++;
				j++;
			}
			
			//�ҵ���ȵ�����ʱ
			//ֱ���ҵ����
			while (j + 1 < nums.length && nums[i + 1] - nums[i] == nums[j + 1] - nums[j]) {
				j++;
			}
			
			//�����ж��ٸ�������
			if (j - i >= 2) {
				int n = j - i + 1;
				count += (n - 1)*(n - 2) / 2;
			}
			
			if (j + 1 < nums.length && nums[i + 1] - nums[i] != nums[j + 1] - nums[j]) {
				i = j;
				j++;
			}
		}
		
		return count;
    }

	public static void main(String[] args) {
//		int[] nums = {1,2,3,4};
		int[] nums = {-2,1,2,4,7,8,9,10,11,13,15,17};

		System.out.println(numberOfArithmeticSlices(nums));
	}

}
