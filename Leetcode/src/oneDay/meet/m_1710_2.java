package oneDay.meet;


public class m_1710_2 {
	public static int majorityElement(int[] nums) {
		//Ħ��ͶƱ �ȼ�������ܳ���һ���Ԫ��
		//�ı�nums���飬�޷�ȷ��������µ�Ԫ�ص��ܸ����Ƿ񳬹�һ��
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == -1) {
				continue;
			}
			else {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] != nums[j] && nums[j] != -1) {
						nums[i] = -1;
						nums[j] = -1;
						break;
					}
				}
			}
		}
		
		
		//Xȷ���Ƿ񳬹�һ��
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != -1) {
				return nums[i];
			}
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,3,4};
		System.out.println(majorityElement(nums));
	}

}
